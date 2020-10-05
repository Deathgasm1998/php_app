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

import java.util.ArrayList;

public class AdapT2 extends RecyclerView.Adapter<AdapT2.MyViewHolder> {

    Context context;
    ArrayList<Tema_2> tema2s;

    public AdapT2 (Context c, ArrayList<Tema_2> tm2){
        context = c;
        tema2s = tm2;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt2_titulo.setText(tema2s.get(position).getTitulo2());
        holder.tvt2_descripcion.setText(tema2s.get(position).getDescripcion2());

        Glide.with(context)
                .load(tema2s.get(position).getImagen2())
                .into(holder.imaget2);
    }

    @Override
    public int getItemCount() {
        return tema2s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt2_titulo,tvt2_descripcion;
        ImageView imaget2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt2_titulo = (TextView) itemView.findViewById(R.id.tvt2_titulo);
            tvt2_descripcion = (TextView) itemView.findViewById(R.id.tvt2_descripcion);

            imaget2 = (ImageView) itemView.findViewById(R.id.imaget2);
        }
    }
}
