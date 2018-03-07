package com.liqy.okhttp.strategy;

/**
 * Created by liqy on 2018/3/7.
 */

public class Order {

    public Channel channel;

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void payOrder(){
        channel.pay();
    }
}
