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

public class AdapAV20 extends RecyclerView.Adapter<AdapAV20.MyViewHolder> {
    Context context;
    ArrayList<Temava_20> tema20s;

    public AdapAV20 (Context c, ArrayList<Temava_20> tm20){
        context = c;
        tema20s = tm20;
    }


    @NonNull
    @Override
    public AdapAV20.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV20.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava20,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV20.MyViewHolder holder, int position) {

        holder.tvta20_titulo.setText(tema20s.get(position).getTitulo20a());
        holder.tvta20_descripcion.setText(tema20s.get(position).getDescripcion20a());

        Glide.with(context)
                .load(tema20s.get(position).getImagen20a())
                .into(holder.imageta20);
    }

    @Override
    public int getItemCount() {
        return tema20s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta20_titulo,tvta20_descripcion;
        ImageView imageta20;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta20_titulo = (TextView) itemView.findViewById(R.id.tvta20_titulo);
            tvta20_descripcion = (TextView) itemView.findViewById(R.id.tvta20_descripcion);

            imageta20 = (ImageView) itemView.findViewById(R.id.imageta20);

        }
    }
}

