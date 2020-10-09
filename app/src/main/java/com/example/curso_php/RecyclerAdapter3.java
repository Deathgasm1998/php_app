package com.example.curso_php;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import curso_intermedio.activitys.tema10inActivity;
import curso_intermedio.activitys.tema2inActivity;
import curso_intermedio.activitys.tema3inActivity;
import curso_intermedio.activitys.tema4inActivity;
import curso_intermedio.activitys.tema5inActivity;
import curso_intermedio.activitys.tema6inActivity;
import curso_intermedio.activitys.tema7inActivity;
import curso_intermedio.activitys.tema8inActivity;
import curso_intermedio.activitys.tema9inActivity;

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.RecyclerHolder> {
    private Context context;
    private List<ItemList> items;
    private List<ItemList> originalItems;
    //private RecyclerItemClick itemClick;

    public RecyclerAdapter3(Context context, List items) {
        this.context = context;
        this.items = items;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view,parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, final int position) {
        final ItemList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescripcion.setText(item.getDescripcion());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //itemClick.itemClick(item);
               if (items.get(position).getTitulo().matches("Tema 1")){
                    Intent iractivity1 = new Intent(context, tema1avaActivity.class);
                    context.startActivity(iractivity1);
                }

                if (items.get(position).getTitulo().matches("Tema 2")){
                    Intent iractivity2 = new Intent(context, tema2avaActivity.class);
                    context.startActivity(iractivity2);
                }
                if (items.get(position).getTitulo().matches("Tema 3")){
                    Intent iractivity3 = new Intent(context, tema3avaActivity.class);
                    context.startActivity(iractivity3);
                }
                if (items.get(position).getTitulo().matches("Tema 4")){
                    Intent iractivity4 = new Intent(context, tema4avaActivity.class);
                    context.startActivity(iractivity4);
                }

                if (items.get(position).getTitulo().matches("Tema 5")){
                    Intent iractivity5 = new Intent(context, tema5avaActivity.class);
                    context.startActivity(iractivity5);
                }

                if (items.get(position).getTitulo().matches("Tema 6")){
                    Intent iractivity6 = new Intent(context, tema6avaActivity.class);
                    context.startActivity(iractivity6);
                }

                if (items.get(position).getTitulo().matches("Tema 7")){
                    Intent iractivity7 = new Intent(context, tema7avaActivity.class);
                    context.startActivity(iractivity7);
                }

                if (items.get(position).getTitulo().matches("Tema 8")){
                    Intent iractivity8 = new Intent(context, tema8avaActivity.class);
                    context.startActivity(iractivity8);
                }
                if (items.get(position).getTitulo().matches("Tema 9")){
                    Intent iractivity9 = new Intent(context, tema9avaActivity.class);
                    context.startActivity(iractivity9);
                }
                if (items.get(position).getTitulo().matches("Tema 10")){
                    Intent iractivity10 = new Intent(context, tema10avaActivity.class);
                    context.startActivity(iractivity10);
                }

            }
        });
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items.clear();
            items.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items.clear();
                List<ItemList> collect = originalItems.stream()
                        .filter(i -> i.getTitulo().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items.addAll(collect);
            }
            else {
                items.clear();
                for (ItemList i : originalItems) {
                    if (i.getTitulo().toLowerCase().contains(strSearch)) {
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{

        private ImageView imgItem;
        private TextView tvTitulo;
        private TextView tvDescripcion;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);

        }
    }

    public  interface RecyclerItemClick {
        void itemClick(ItemList item);
    }


}

