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

public class AdapAV18 extends RecyclerView.Adapter<AdapAV18.MyViewHolder> {
    Context context;
    ArrayList<Temava_18> tema18s;

    public AdapAV18 (Context c, ArrayList<Temava_18> tm18){
        context = c;
        tema18s = tm18;
    }


    @NonNull
    @Override
    public AdapAV18.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV18.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava18,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV18.MyViewHolder holder, int position) {

        holder.tvta18_titulo.setText(tema18s.get(position).getTitulo18a());
        holder.tvta18_descripcion.setText(tema18s.get(position).getDescripcion18a());

        Glide.with(context)
                .load(tema18s.get(position).getImagen18a())
                .into(holder.imageta18);
    }

    @Override
    public int getItemCount() {
        return tema18s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta18_titulo,tvta18_descripcion;
        ImageView imageta18;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta18_titulo = (TextView) itemView.findViewById(R.id.tvta18_titulo);
            tvta18_descripcion = (TextView) itemView.findViewById(R.id.tvta18_descripcion);

            imageta18 = (ImageView) itemView.findViewById(R.id.imageta18);

        }
    }
}
