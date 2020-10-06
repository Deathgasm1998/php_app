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

public class AdapIT4 extends RecyclerView.Adapter<AdapIT4.MyViewHolder> {

    Context context;
    ArrayList<Temain_4> temain4s;

    public AdapIT4 (Context c, ArrayList<Temain_4> tmi4){
        context = c;
        temain4s = tmi4;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter4,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvti4_titulo.setText(temain4s.get(position).getTitulo4i());
        holder.tvti4_descripcion.setText(temain4s.get(position).getDescripcion4i());

        Glide.with(context)
                .load(temain4s.get(position).getImage4i())
                .into(holder.imageit4);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
/////////////////////////////////////////////////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti4_titulo,tvti4_descripcion;
        ImageView imageit4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti4_titulo = (TextView) itemView.findViewById(R.id.tvit4_titulo);
            tvti4_descripcion = (TextView) itemView.findViewById(R.id.tvit4_descripcion);

            imageit4 = (ImageView) itemView.findViewById(R.id.imageit4);

        }
    }
}
