package com.mozi.lintcode.sort;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2019/11/12  http://collabedit.com/bfkh7
 */
public class CacheImpl implements  ICache{

    private static ConcurrentHashMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
    @Override
    public Object get(String key) {
        if(caches.containsKey(key)){

//          缓存对象超过指定时间后会自动删除，如果没有指定时间，则统一超过7天后清除
            if(isInValid(key))
                deleteKey(key);
            return caches.get(key).getDatas();
        }
        return null;
    }

    @Override
    public void put(String key, Cache cache) {
        caches.put(key,cache);

    }


    @Override
    public void put(String key, Object data, long expired) {
        expired = expired > 0 ? expired : 7*24*60*60*1000L;
        put(key, new Cache(data, expired, System.currentTimeMillis()));
    }


    @Override
    public boolean isInValid(String key) {

        if (!caches.containsKey(key)) {
            return true;
        }
        Cache cache = caches.get(key);
        long timeOut = cache.getTimeOut();
        long lastRefreshTime = cache.getLastRefeshTime();
        if (timeOut == 0 || System.currentTimeMillis() - lastRefreshTime >= timeOut) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteKey(String key) {

        if (caches.containsKey(key)) {
            caches.remove(key);
        }

    }
}
