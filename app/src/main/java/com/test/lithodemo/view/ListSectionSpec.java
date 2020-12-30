package com.test.lithodemo.view;

import android.graphics.Color;
import android.util.Log;

import com.facebook.litho.EventHandler;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.annotations.OnRefresh;
import com.facebook.litho.sections.common.SingleComponentSection;

import java.util.List;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateInitialState
    static void initData(SectionContext c) {

        Log.i("list", "refresh");

    }

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c, @Prop(optional = true) List<String> list) {
        Children.Builder builder = Children.create();

        for (int i = 0; i < list.size(); i++) {

            builder.child(
                    SingleComponentSection.create(c)
                            .key(String.valueOf(i))
                            .component(ListItem.create(c)
                                    .color(i % 2 == 0 ? Color.GREEN : Color.BLUE)
                                    .title(i + list.get(i))
                                    .index(i)
                                    .subtitle("litho")
                                    .build()));
        }
        return builder.build();
    }

    @OnRefresh
    static void onRefresh(SectionContext c) {

        Log.i("list", "refresh");

    }
}
