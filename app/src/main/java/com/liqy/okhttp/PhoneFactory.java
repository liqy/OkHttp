package com.liqy.okhttp;

/**
 * Created by liqy on 2018/3/7.
 */

public class PhoneFactory implements Factory{

    @Override
    public Phone create() {
        return new IPhone();
    }
}
