package com.liqy.okhttp.observer;

/**
 * Created by liqy on 2018/3/7.
 */

public interface Observable {
    /**
     * 订阅
     * @param observer
     */
    public void subscribe(Observer observer);

    /**
     * 解除点阅
     * @param observer
     */
    public void unSubscribe(Observer observer);

    /**
     * 通知
     * @param data
     */
    public void notify(String data);

}
