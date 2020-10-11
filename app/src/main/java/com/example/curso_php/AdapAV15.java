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

public class AdapAV15 extends RecyclerView.Adapter<AdapAV15.MyViewHolder> {
    Context context;
    ArrayList<Temava_15> tema15s;

    public AdapAV15 (Context c, ArrayList<Temava_15> tm15){
        context = c;
        tema15s = tm15;
    }


    @NonNull
    @Override
    public AdapAV15.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV15.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava15,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV15.MyViewHolder holder, int position) {

        holder.tvta15_titulo.setText(tema15s.get(position).getTitulo15a());
        holder.tvta15_descripcion.setText(tema15s.get(position).getDescripcion15a());

        Glide.with(context)
                .load(tema15s.get(position).getImagen15a())
                .into(holder.imageta15);
    }

    @Override
    public int getItemCount() {
        return tema15s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta15_titulo,tvta15_descripcion;
        ImageView imageta15;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta15_titulo = (TextView) itemView.findViewById(R.id.tvta15_titulo);
            tvta15_descripcion = (TextView) itemView.findViewById(R.id.tvta15_descripcion);

            imageta15 = (ImageView) itemView.findViewById(R.id.imageta15);

        }
    }
}
