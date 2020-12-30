package com.test.lithodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.test.lithodemo.view.ListItem;
import com.test.lithodemo.view.ListSection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentContext componentContext = new ComponentContext(this);

        Component customView = ListItem.create(componentContext).build();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("第" + i + "个");
        }

        Component recComponent = RecyclerCollectionComponent.create(componentContext)
                .disablePTR(false).section(ListSection.create(new SectionContext(componentContext)).list(list).build()).build();
        View view = LithoView.create(this, recComponent);
        setContentView(view);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}