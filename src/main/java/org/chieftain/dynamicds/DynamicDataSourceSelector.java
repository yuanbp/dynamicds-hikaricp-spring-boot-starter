package org.chieftain.dynamicds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author chieftain
 * @date 2019-09-27 21:47
 */
public class DynamicDataSourceSelector extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceKey.getDataSourceKey();
    }
}
