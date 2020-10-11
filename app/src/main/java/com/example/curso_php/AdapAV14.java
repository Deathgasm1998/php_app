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

public class AdapAV14 extends RecyclerView.Adapter<AdapAV14.MyViewHolder> {
    Context context;
    ArrayList<Temava_14> tema14s;

    public AdapAV14 (Context c, ArrayList<Temava_14> tm14){
        context = c;
        tema14s = tm14;
    }


    @NonNull
    @Override
    public AdapAV14.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV14.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava14,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV14.MyViewHolder holder, int position) {

        holder.tvta14_titulo.setText(tema14s.get(position).getTitulo14a());
        holder.tvta14_descripcion.setText(tema14s.get(position).getDescripcion14a());

        Glide.with(context)
                .load(tema14s.get(position).getImagen14a())
                .into(holder.imageta14);
    }

    @Override
    public int getItemCount() {
        return tema14s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta14_titulo,tvta14_descripcion;
        ImageView imageta14;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta14_titulo = (TextView) itemView.findViewById(R.id.tvta14_titulo);
            tvta14_descripcion = (TextView) itemView.findViewById(R.id.tvta14_descripcion);

            imageta14 = (ImageView) itemView.findViewById(R.id.imageta14);

        }
    }
}
