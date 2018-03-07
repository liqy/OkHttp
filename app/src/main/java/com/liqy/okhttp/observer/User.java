package com.liqy.okhttp.observer;

import android.util.Log;

/**
 * Created by liqy on 2018/3/7.
 */

public class User implements Observer{
    @Override
    public void update(String data) {
        Log.d(getClass().getSimpleName(),data+",记得带伞");
    }
}
