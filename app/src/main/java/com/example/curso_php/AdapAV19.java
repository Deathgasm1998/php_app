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

public class AdapAV19 extends RecyclerView.Adapter<AdapAV19.MyViewHolder> {
    Context context;
    ArrayList<Temava_19> tema19s;

    public AdapAV19 (Context c, ArrayList<Temava_19> tm19){
        context = c;
        tema19s = tm19;
    }


    @NonNull
    @Override
    public AdapAV19.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV19.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava19,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV19.MyViewHolder holder, int position) {

        holder.tvta19_titulo.setText(tema19s.get(position).getTitulo19a());
        holder.tvta19_descripcion.setText(tema19s.get(position).getDescripcion19a());

        Glide.with(context)
                .load(tema19s.get(position).getImagen19a())
                .into(holder.imageta19);
    }

    @Override
    public int getItemCount() {
        return tema19s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta19_titulo,tvta19_descripcion;
        ImageView imageta19;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta19_titulo = (TextView) itemView.findViewById(R.id.tvta19_titulo);
            tvta19_descripcion = (TextView) itemView.findViewById(R.id.tvta19_descripcion);

            imageta19 = (ImageView) itemView.findViewById(R.id.imageta19);

        }
    }
}
