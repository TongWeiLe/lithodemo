package com.test.lithodemo;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final String TAG = "RecyclerViewActivity";

    private long statTime = 0L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate");
        statTime = System.currentTimeMillis();
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = findViewById(R.id.rv_test);

        MyAdapter adapter = new MyAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        Looper.myLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {

                Log.i(TAG, "idlehandler cost time:  " + (System.currentTimeMillis() - statTime));
                return false;
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Log.i(TAG, "cost time:  " + (System.currentTimeMillis() - statTime));
    }
}
