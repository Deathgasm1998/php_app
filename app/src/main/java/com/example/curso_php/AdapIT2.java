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

import curso_intermedio.AdapIT1;

public class AdapIT2 extends RecyclerView.Adapter<AdapIT2.MyViewHolder>{
    Context context;
    ArrayList<Temain_2> temain2s;

    public AdapIT2 (Context c, ArrayList<Temain_2> tmi2){
        context = c;
        temain2s = tmi2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvti2_titulo.setText(temain2s.get(position).getTitulo2i());
        holder.tvti2_descripcion.setText(temain2s.get(position).getDescripcion2i());

        Glide.with(context)
                .load(temain2s.get(position).getImagen2i())
                .into(holder.imageit2);
    }

    @Override
    public int getItemCount() {
        return temain2s.size();
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti2_titulo,tvti2_descripcion;
        ImageView imageit2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti2_titulo = (TextView) itemView.findViewById(R.id.tvit2_titulo);
            tvti2_descripcion = (TextView) itemView.findViewById(R.id.tvit2_descripcion);

            imageit2 = (ImageView) itemView.findViewById(R.id.imageit2);

        }
    }
}
