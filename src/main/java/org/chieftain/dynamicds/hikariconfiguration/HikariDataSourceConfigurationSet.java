package org.chieftain.dynamicds.hikariconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chieftain
 * @date 2019-09-27 15:45
 */
@Data
@Component
@ConfigurationProperties(prefix = "dbconfig.hikariconfig")
public class HikariDataSourceConfigurationSet {

    public static final String DEFAULT_KEY = "master";

    private String enable;

    private String masterKey;

    private List<HikariDataSourceConfiguration> dynamicDataSource = new ArrayList<>();
}
