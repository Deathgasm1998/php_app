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

import curso_basico.activitys.tema1;
import curso_basico.activitys.tema10Activity;
import curso_basico.activitys.tema11Activity;
import curso_basico.activitys.tema12Activity;
import curso_basico.activitys.tema13Activity;
import curso_basico.activitys.tema14Activity;
import curso_basico.activitys.tema15Activity;
import curso_basico.activitys.tema2Activity;
import curso_basico.activitys.tema3Activity;
import curso_basico.activitys.tema4Activity;
import curso_basico.activitys.tema5Activity;
import curso_basico.activitys.tema6Activity;
import curso_basico.activitys.tema7Activity;
import curso_basico.activitys.tema8Activity;
import curso_basico.activitys.tema9Activity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private Context context;
    private List<ItemList> items;
    private List<ItemList> originalItems;
    //private RecyclerItemClick itemClick;

    public RecyclerAdapter(Context context, List items) {
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
                 if (items.get(position).getTitulo().matches("Introducción")){
                     Intent iractivity1 = new Intent(context, tema1.class);
                     context.startActivity(iractivity1);
                 }
                 if (items.get(position).getTitulo().matches("Sintaxis básica")){
                     Intent iractivity2 = new Intent(context, tema2Activity.class);
                     context.startActivity(iractivity2);
                 }
                 if (items.get(position).getTitulo().matches("Programa ''Hola Mundo'' ")){
                     Intent iractivity3 = new Intent(context, tema3Activity.class);
                     context.startActivity(iractivity3);
                 }
                 if (items.get(position).getTitulo().matches("Variables")){
                     Intent iractivity4 = new Intent(context, tema4Activity.class);
                     context.startActivity(iractivity4);
                 }
                 if (items.get(position).getTitulo().matches("Operadores")){
                     Intent iractivity5 = new Intent(context, tema5Activity.class);
                     context.startActivity(iractivity5);
                 }

                 if (items.get(position).getTitulo().matches("Arreglos")){
                     Intent iractivity6 = new Intent(context, tema6Activity.class);
                     context.startActivity(iractivity6);
                 }

                 if (items.get(position).getTitulo().matches("tema 7")){
                     Intent iractivity7 = new Intent(context, tema7Activity.class);
                     context.startActivity(iractivity7);
                 }
                 if (items.get(position).getTitulo().matches("tema 8")){
                     Intent iractivity8 = new Intent(context, tema8Activity.class);
                     context.startActivity(iractivity8);
                 }

              if (items.get(position).getTitulo().matches("tema 9")){
                     Intent iractivity9 = new Intent(context, tema9Activity.class);
                     context.startActivity(iractivity9);
                 }

                 if (items.get(position).getTitulo().matches("tema 10")){
                     Intent iractivity10 = new Intent(context, tema10Activity.class);
                     context.startActivity(iractivity10);
                 }

                 if (items.get(position).getTitulo().matches("tema 11")){
                     Intent iractivity11 = new Intent(context, tema11Activity.class);
                     context.startActivity(iractivity11);
                 }

                 if (items.get(position).getTitulo().matches("tema 12")){
                     Intent iractivity12 = new Intent(context, tema12Activity.class);
                     context.startActivity(iractivity12);
                 }

                 if (items.get(position).getTitulo().matches("tema 13")){
                     Intent iractivity13 = new Intent(context, tema13Activity.class);
                     context.startActivity(iractivity13);
                 }
                 if (items.get(position).getTitulo().matches("tema 14")){
                     Intent iractivity14 = new Intent(context, tema14Activity.class);
                     context.startActivity(iractivity14);
                 }

                 if (items.get(position).getTitulo().matches("tema 15")){
                     Intent iractivity15 = new Intent(context, tema15Activity.class);
                     context.startActivity(iractivity15);
                 }
                 if (items.get(position).getTitulo().matches("tema 16")){
                     Intent iractivity16 = new Intent(context, tema16Activity.class);
                     context.startActivity(iractivity16);
                 }
                 if (items.get(position).getTitulo().matches("tema 17")){
                     Intent iractivity17 = new Intent(context, tema17Activity.class);
                     context.startActivity(iractivity17);
                 }

                 if (items.get(position).getTitulo().matches("tema 18")){
                     Intent iractivity18 = new Intent(context, tema18Activity.class);
                     context.startActivity(iractivity18);
                 }

                 if (items.get(position).getTitulo().matches("tema 19")){
                     Intent iractivity19 = new Intent(context, tema19Activity.class);
                     context.startActivity(iractivity19);
                 }
                 if (items.get(position).getTitulo().matches("tema 20")){
                     Intent iractivity20 = new Intent(context, tema20Activity.class);
                     context.startActivity(iractivity20);
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
