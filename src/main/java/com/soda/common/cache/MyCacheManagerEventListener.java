package com.soda.common.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;

import java.util.Properties;

public class MyCacheManagerEventListener implements CacheManagerEventListener {

    private final CacheManager cacheManager;

    private Properties properties;

    public MyCacheManagerEventListener(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public MyCacheManagerEventListener(CacheManager cacheManager, Properties properties) {
        this.cacheManager = cacheManager;
        this.properties = properties;
    }

    @Override
    public void init() throws CacheException {
        System.out.println("init.....");
    }

    @Override
    public Status getStatus() {
        System.out.println("getStatus.....");
        return null;
    }

    @Override
    public void dispose() throws CacheException {
        System.out.println("dispose......");
    }

    @Override
    public void notifyCacheAdded(String cacheName) {
        System.out.println("cacheAdded......." + cacheName);
        System.out.println(cacheManager.getCache(cacheName));
    }

    @Override
    public void notifyCacheRemoved(String cacheName) {
        System.out.println("cacheRemoved......" + cacheName);
    }

}
