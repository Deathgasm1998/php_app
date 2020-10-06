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

public class AdapIT3 extends RecyclerView.Adapter<AdapIT3.MyViewHolder> {
    Context context;
    ArrayList<Temain_3> temain3s;

    public AdapIT3 (Context c, ArrayList<Temain_3> tmi3){
        context = c;
        temain3s = tmi3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter3,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvti3_titulo.setText(temain3s.get(position).getTitulo3i());
        holder.tvti3_descripcion.setText(temain3s.get(position).getDescripcion3i());

        Glide.with(context)
                .load(temain3s.get(position).getImagen3i())
                .into(holder.imageit3);
    }

    @Override
    public int getItemCount() {
        return temain3s.size();
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti3_titulo,tvti3_descripcion;
        ImageView imageit3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti3_titulo = (TextView) itemView.findViewById(R.id.tvit3_titulo);
            tvti3_descripcion = (TextView) itemView.findViewById(R.id.tvit3_descripcion);

            imageit3 = (ImageView) itemView.findViewById(R.id.imageit3);

        }
    }
}
