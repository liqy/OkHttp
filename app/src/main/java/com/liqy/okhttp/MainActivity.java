package com.liqy.okhttp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liqy.okhttp.observer.Observable;
import com.liqy.okhttp.observer.Observer;
import com.liqy.okhttp.observer.User;
import com.liqy.okhttp.observer.Weather;
import com.liqy.okhttp.strategy.AliPay;
import com.liqy.okhttp.strategy.Order;
import com.liqy.okhttp.strategy.UnionPay;
import com.liqy.okhttp.strategy.WeChat;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Factory factory = new PhoneFactory();
        Phone phone = factory.create();
        phone.call();

//单例
        final OkHttpClient client = new OkHttpClient();

        MyClass myClass = new MyClass.Builder().name("1510C").nums(37).build();

        Log.d(getLocalClassName(), myClass.toString());

        ImageView img = (ImageView) findViewById(R.id.img);
        Glide.with(this).load("https://github.com/bumptech/glide/blob/3.0/static/glide_logo.png").into(img);


        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String url = strings[0];
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    return response.body().string();
                } catch (IOException e) {

                }
                return null;

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (TextUtils.isEmpty(s)) {

                } else {

                }

                final Request request = new Request.Builder()
                        .url("https://zhuanlan.zhihu.com/")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String html = response.body().string();

                    }
                });

            }
        }.execute("https://zhuanlan.zhihu.com/");


        Observable observable = new Weather();

        Observer observer = new User();

        observable.subscribe(observer);


        observable.notify("要下雨了");

        Order order = new Order();
        order.setChannel(new UnionPay());
        order.payOrder();

    }
}
