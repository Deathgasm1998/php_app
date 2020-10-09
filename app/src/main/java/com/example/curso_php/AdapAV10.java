package com.example.curso_php;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curso_php.R;

import java.util.ArrayList;

import curso_intermedio.temas.Temain_1;

public class AdapAV10 extends RecyclerView.Adapter<AdapAV10.MyViewHolder> {
    Context context;
    ArrayList<Temava_10> tema10s;

    public AdapAV10 (Context c, ArrayList<Temava_10> tm10){
        context = c;
        tema10s = tm10;
    }


    @NonNull
    @Override
    public AdapAV10.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV10.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava10,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV10.MyViewHolder holder, int position) {

        holder.tvta10_titulo.setText(tema10s.get(position).getTitulo10a());
        holder.tvta10_descripcion.setText(tema10s.get(position).getDescripcion10a());

        Glide.with(context)
                .load(tema10s.get(position).getImagen10a())
                .into(holder.imageta10);
    }

    @Override
    public int getItemCount() {
        return tema10s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta10_titulo,tvta10_descripcion;
        ImageView imageta10;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta10_titulo = (TextView) itemView.findViewById(R.id.tvta10_titulo);
            tvta10_descripcion = (TextView) itemView.findViewById(R.id.tvta10_descripcion);

            imageta10 = (ImageView) itemView.findViewById(R.id.imageta10);

        }
    }
}
