package com.liqy.okhttp;

import android.util.Log;

/**
 * Created by liqy on 2018/3/7.
 */

public class IPhone implements Phone{
    @Override
    public void call() {
        Log.d(getClass().getSimpleName(),"我用IPhone手机打电话");
    }
}
