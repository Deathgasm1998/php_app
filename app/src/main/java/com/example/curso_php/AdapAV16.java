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

public class AdapAV16 extends RecyclerView.Adapter<AdapAV16.MyViewHolder> {
    Context context;
    ArrayList<Temava_16> tema16s;

    public AdapAV16 (Context c, ArrayList<Temava_16> tm16){
        context = c;
        tema16s = tm16;
    }


    @NonNull
    @Override
    public AdapAV16.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV16.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava16,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV16.MyViewHolder holder, int position) {

        holder.tvta16_titulo.setText(tema16s.get(position).getTitulo16a());
        holder.tvta16_descripcion.setText(tema16s.get(position).getDescripcion16a());

        Glide.with(context)
                .load(tema16s.get(position).getImagen16a())
                .into(holder.imageta16);
    }

    @Override
    public int getItemCount() {
        return tema16s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta16_titulo,tvta16_descripcion;
        ImageView imageta16;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta16_titulo = (TextView) itemView.findViewById(R.id.tvta16_titulo);
            tvta16_descripcion = (TextView) itemView.findViewById(R.id.tvta16_descripcion);

            imageta16 = (ImageView) itemView.findViewById(R.id.imageta16);

        }
    }
}
