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

public class AdapAV12 extends RecyclerView.Adapter<AdapAV12.MyViewHolder> {
    Context context;
    ArrayList<Temava_12> tema12s;

    public AdapAV12 (Context c, ArrayList<Temava_12> tm12){
        context = c;
        tema12s = tm12;
    }


    @NonNull
    @Override
    public AdapAV12.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV12.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava12,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV12.MyViewHolder holder, int position) {

        holder.tvta12_titulo.setText(tema12s.get(position).getTitulo12a());
        holder.tvta12_descripcion.setText(tema12s.get(position).getDescripcion12a());

        Glide.with(context)
                .load(tema12s.get(position).getImagen12a())
                .into(holder.imageta12);
    }

    @Override
    public int getItemCount() {
        return tema12s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta12_titulo,tvta12_descripcion;
        ImageView imageta12;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta12_titulo = (TextView) itemView.findViewById(R.id.tvta12_titulo);
            tvta12_descripcion = (TextView) itemView.findViewById(R.id.tvta12_descripcion);

            imageta12 = (ImageView) itemView.findViewById(R.id.imageta12);

        }
    }
}
