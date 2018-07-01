package com.example.lap11799.rxbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        Button buttonEvent1 = findViewById(R.id.buttonEvent1);
        Button buttonEvent2 = findViewById(R.id.buttonEvent2);

        ((MyApplication) getApplication())
                .bus()
                .toObservable()
                .subscribe(new Consumer<Object>() {
                               @Override
                               public void accept(Object object) throws Exception {
                                   if (object instanceof Event.EventTypeOne) {
                                       textView.setText("Start Event 1");
                                   } else if (object instanceof Event.EventTypeTwo) {
                                       textView.setText("Start Event 2");
                                   }
                               }
                           });

        buttonEvent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication())
                        .bus()
                        .send(new Event.EventTypeOne());
            }
        });
        buttonEvent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication())
                        .bus()
                        .send(new Event.EventTypeTwo());
            }
        });

    }
}
