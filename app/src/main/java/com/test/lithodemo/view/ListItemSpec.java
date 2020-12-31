package com.test.lithodemo.view;

import android.graphics.Color;
import android.util.Log;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.EventHandler;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Param;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.test.lithodemo.R;

import static com.facebook.yoga.YogaEdge.ALL;
@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop(optional = true) int color,
                                    @Prop(optional = true) String title, @Prop(optional = true) String subtitle,
                                    @Prop(optional = true) int index) {
        if (index % 2 == 0) {
            return Column.create(c)
                    .paddingDip(ALL, 16)
                    .backgroundColor(color)
                    .child(
                            Text.create(c)
                                    .text(title)
                                    .textSizeSp(40))
                    .child(
                            Text.create(c)
                                    .text(subtitle)
                                    .textSizeSp(20))
                    .child(
                            Image.create(c).drawableRes(R.drawable.img_1)).clickHandler(ListItem.onListClicked(c, "可点击"))


                    .build();
        } else {
            return Row.create(c).backgroundColor(Color.WHITE).child(
                    Text.create(c).text("横着").textColor(Color.BLACK)
            ).child(
                    Image.create(c).drawableRes(R.drawable.img_2).marginDip(YogaEdge.LEFT, 50)
            ).build();
        }


    }

    @OnEvent(ClickEvent.class)
    static void onListClicked(ComponentContext componentContext, @Param String param) {
        Log.i("List", param);
    }

}
