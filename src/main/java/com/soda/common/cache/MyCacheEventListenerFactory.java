package com.soda.common.cache;

import com.soda.common.cache.MyCacheEventListener;
import net.sf.ehcache.config.ManagementRESTServiceConfiguration;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

public class MyCacheEventListenerFactory extends CacheEventListenerFactory {

    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new MyCacheEventListener();
    }

}
