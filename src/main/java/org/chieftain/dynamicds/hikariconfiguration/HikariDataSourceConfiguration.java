package org.chieftain.dynamicds.hikariconfiguration;

import lombok.Data;
import org.chieftain.dynamicds.utils.ReflectUtils;

import java.util.Properties;

/**
 * @author chieftain
 * @date 2019-09-27 15:55
 */
@Data
public class HikariDataSourceConfiguration {

    private String key;

    private String url;
    private String driverClassName;
    private String username;
    private String password;

    private String minimumIdle;
    private String maximumPoolSize;
    private String autoCommit;
    private String idleTimeout;
    private String poolName;
    private String maxLifetime;
    private String connectionTimeout;
    private String connectionTestQuery;

    public Properties convertProperties () {
        Properties properties = ReflectUtils.convertProperties(this, "key");
        assert properties != null;
        if (properties.containsKey("url")) {
            properties.setProperty("jdbcUrl", properties.getProperty("url"));
            properties.remove("url");
        }
        return properties;
    }

//    public Properties convertProperties () {
//        Properties properties = new Properties();
//        if (StringUtils.isNotBlank(this.getKey())) {
//            properties.setProperty("key", this.getKey());
//        }
//        if (StringUtils.isNotBlank(this.getUrl())) {
//            properties.setProperty("jdbcUrl", this.getUrl());
//        }
//        if (StringUtils.isNotBlank(this.getDriverClassName())) {
//            properties.setProperty("driverClassName", this.getDriverClassName());
//        }
//        if (StringUtils.isNotBlank(this.getUsername())) {
//            properties.setProperty("username", this.getUsername());
//        }
//        if (StringUtils.isNotBlank(this.getPassword())) {
//            properties.setProperty("password", this.getPassword());
//        }
//        if (StringUtils.isNotBlank(this.getMinimumIdle())) {
//            properties.setProperty("minimumIdle", this.getMinimumIdle());
//        }
//        if (StringUtils.isNotBlank(this.getMaximumPoolSize())) {
//            properties.setProperty("maximumPoolSize", this.getMaximumPoolSize());
//        }
//        if (StringUtils.isNotBlank(this.getAutoCommit())) {
//            properties.setProperty("autoCommit", this.getAutoCommit());
//        }
//        if (StringUtils.isNotBlank(this.getIdleTimeout())) {
//            properties.setProperty("idleTimeout", this.getIdleTimeout());
//        }
//        if (StringUtils.isNotBlank(this.getPoolName())) {
//            properties.setProperty("poolName", this.getPoolName());
//        }
//        if (StringUtils.isNotBlank(this.getMaxLifetime())) {
//            properties.setProperty("maxLifetime", this.getMaxLifetime());
//        }
//        if (StringUtils.isNotBlank(this.getConnectionTimeout())) {
//            properties.setProperty("connectionTimeout", this.getConnectionTimeout());
//        }
//        if (StringUtils.isNotBlank(this.getConnectionTestQuery())) {
//            properties.setProperty("connectionTestQuery", this.getConnectionTestQuery());
//        }
//        return properties;
//    }
}
