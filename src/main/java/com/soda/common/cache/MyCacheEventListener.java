package com.soda.common.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class MyCacheEventListener implements CacheEventListener {

    @Override
    public void notifyElementRemoved(Ehcache ehcache, Element element) throws CacheException {
        System.out.println("ElementRemoved-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName()
                + ", Element Key: " + element.getObjectKey());
    }

    @Override
    public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
        System.out.println("ElementPut-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName()
                + ", Element Key: " + element.getObjectKey());
    }

    @Override
    public void notifyElementUpdated(Ehcache ehcache, Element element) throws CacheException {
        System.out.println("ElementUpdated-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName()
                + ", Element Key: " + element.getObjectKey());
    }

    @Override
    public void notifyElementExpired(Ehcache ehcache, Element element) {
        System.out.println("ElementExpired-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName()
                + ", Element Key: " + element.getObjectKey());
    }

    @Override
    public void notifyElementEvicted(Ehcache ehcache, Element element) {
        System.out.println("ElementEvicted-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName()
                + ", Element Key: " + element.getObjectKey());
    }

    @Override
    public void notifyRemoveAll(Ehcache ehcache) {
        System.out.println("RemoveAll-------------------------------------");
        System.out.println("Ehcache Name: " + ehcache.getName());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void dispose() {
        System.out.println("dispose-------------------------------------");
    }
}
