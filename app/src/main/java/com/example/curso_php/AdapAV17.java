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

public class AdapAV17 extends RecyclerView.Adapter<AdapAV17.MyViewHolder> {
    Context context;
    ArrayList<Temava_17> tema17s;

    public AdapAV17 (Context c, ArrayList<Temava_17> tm17){
        context = c;
        tema17s = tm17;
    }


    @NonNull
    @Override
    public AdapAV17.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV17.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava17,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV17.MyViewHolder holder, int position) {

        holder.tvta17_titulo.setText(tema17s.get(position).getTitulo17a());
        holder.tvta17_descripcion.setText(tema17s.get(position).getDescripcion17a());

        Glide.with(context)
                .load(tema17s.get(position).getImagen17a())
                .into(holder.imageta17);
    }

    @Override
    public int getItemCount() {
        return tema17s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta17_titulo,tvta17_descripcion;
        ImageView imageta17;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta17_titulo = (TextView) itemView.findViewById(R.id.tvta17_titulo);
            tvta17_descripcion = (TextView) itemView.findViewById(R.id.tvta17_descripcion);

            imageta17 = (ImageView) itemView.findViewById(R.id.imageta17);

        }
    }
}
