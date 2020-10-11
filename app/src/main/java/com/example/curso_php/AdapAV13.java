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

public class AdapAV13 extends RecyclerView.Adapter<AdapAV13.MyViewHolder> {
    Context context;
    ArrayList<Temava_13> tema13s;

    public AdapAV13 (Context c, ArrayList<Temava_13> tm13){
        context = c;
        tema13s = tm13;
    }


    @NonNull
    @Override
    public AdapAV13.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV13.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava13,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV13.MyViewHolder holder, int position) {

        holder.tvta13_titulo.setText(tema13s.get(position).getTitulo13a());
        holder.tvta13_descripcion.setText(tema13s.get(position).getDescripcion13a());

        Glide.with(context)
                .load(tema13s.get(position).getImagen13a())
                .into(holder.imageta13);
    }

    @Override
    public int getItemCount() {
        return tema13s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta13_titulo,tvta13_descripcion;
        ImageView imageta13;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta13_titulo = (TextView) itemView.findViewById(R.id.tvta13_titulo);
            tvta13_descripcion = (TextView) itemView.findViewById(R.id.tvta13_descripcion);

            imageta13 = (ImageView) itemView.findViewById(R.id.imageta13);

        }
    }
}
