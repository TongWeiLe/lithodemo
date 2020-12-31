package com.test.lithodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public List<String> data = new ArrayList<>();
    Context context;

    public MyAdapter(Context context) {

        this.context = context;
        for (int i = 0; i < 10; i++) {

            data.add("第" +i+"个");
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 2 ==0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);

        View view2 = LayoutInflater.from(context).inflate(R.layout.recycler_item_two, parent, false);

        if (viewType == 1) {

            return new ViewHolder(view);
        } else {
            return new ViewHolder(view2);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = data.get(position);

        holder.title.setText(title);
        holder.subtitle.setText("litho");
        if (position % 2 == 0) {

            holder.icon.setImageResource(R.drawable.img_1);
        } else {
            holder.icon.setImageResource(R.drawable.img_2);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView subtitle;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            subtitle = itemView.findViewById(R.id.tv_subtitle);
            icon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
