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
}
