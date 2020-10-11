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

public class AdapAV11 extends RecyclerView.Adapter<AdapAV11.MyViewHolder> {
    Context context;
    ArrayList<Temava_11> tema11s;

    public AdapAV11 (Context c, ArrayList<Temava_11> tm11){
        context = c;
        tema11s = tm11;
    }


    @NonNull
    @Override
    public AdapAV11.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV11.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava11,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV11.MyViewHolder holder, int position) {

        holder.tvta11_titulo.setText(tema11s.get(position).getTitulo11a());
        holder.tvta11_descripcion.setText(tema11s.get(position).getDescripcion11a());

        Glide.with(context)
                .load(tema11s.get(position).getImagen11a())
                .into(holder.imageta11);
    }

    @Override
    public int getItemCount() {
        return tema11s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta11_titulo,tvta11_descripcion;
        ImageView imageta11;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta11_titulo = (TextView) itemView.findViewById(R.id.tvta11_titulo);
            tvta11_descripcion = (TextView) itemView.findViewById(R.id.tvta11_descripcion);

            imageta11 = (ImageView) itemView.findViewById(R.id.imageta11);

        }
    }
}
