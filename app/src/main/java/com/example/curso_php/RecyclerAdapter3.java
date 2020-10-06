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

import curso_avanzado.temaa_1;

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
                    Intent iractivity1 = new Intent(context, temaa_1.class);
                    context.startActivity(iractivity1);
                }
               /*  if (items.get(position).getTitulo().matches("Tema 2")){
                    Intent iractivity2 = new Intent(context,temaa_1.class);
                    context.startActivity(iractivity2);
                }*/

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

