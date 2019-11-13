package com.mozi.lintcode.sort;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2019/11/12
 */
public class Cache {


    private Object datas;//数据
    private long timeOut;//数据的失效时间,
    private long lastRefeshTime;//最后的刷新时间

    public Cache(Object datas, long timeOut, long lastRefeshTime) {
        this.datas = datas;
        this.timeOut = timeOut;
        this.lastRefeshTime = lastRefeshTime;
    }
    public Object getDatas() {
        return datas;
    }
    public void setDatas(Object datas) {
        this.datas = datas;
    }
    public long getTimeOut() {
        return timeOut;
    }
    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
    public long getLastRefeshTime() {
        return lastRefeshTime;
    }
    public void setLastRefeshTime(long lastRefeshTime) {
        this.lastRefeshTime = lastRefeshTime;
    }
}
