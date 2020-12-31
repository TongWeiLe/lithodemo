package com.test.lithodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.test.lithodemo.view.ListSection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private long statTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        statTime = System.currentTimeMillis();
        ComponentContext componentContext = new ComponentContext(this);

//        Component customView = ListItem.create(componentContext).build();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("第" + i + "个");
        }

        RecyclerCollectionComponent recComponent = RecyclerCollectionComponent.create(componentContext)
                .disablePTR(true).section(ListSection.create(new SectionContext(componentContext)).list(list).build()).build();
        View view = LithoView.create(this, recComponent);
        setContentView(view);

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

        Log.i(TAG, "onWindowFocusChanged cost time:  " + (System.currentTimeMillis() - statTime));
    }
}