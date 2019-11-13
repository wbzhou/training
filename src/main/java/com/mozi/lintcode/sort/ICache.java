package com.mozi.lintcode.sort;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2019/11/12
 */
public interface ICache {

    public Object get(String key);//获取数据
    public void put(String key,Cache cache);//放入缓存
    public void put(String key,Object data,long expired);//放入缓存,-1表示不失效
    boolean isInValid(String key);
    void deleteKey(String key);

}
