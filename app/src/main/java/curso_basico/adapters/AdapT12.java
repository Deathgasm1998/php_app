package curso_basico.adapters;

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
import curso_basico.temas.Tema_12;

import java.util.ArrayList;


public class AdapT12 extends RecyclerView.Adapter<AdapT12.MyViewHolder> {

    Context context;
    ArrayList<Tema_12> tema12s;

    public  AdapT12 (Context c,ArrayList<Tema_12> tm12){
        context = c;
        tema12s = tm12;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema12,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt12_titulo.setText(tema12s.get(position).getTitulo12());
        holder.tvt12_descripcion.setText(tema12s.get(position).getDescripcion12());

        Glide.with(context)
                .load(tema12s.get(position).getImagen12())
                .into(holder.imaget12);


    }

    @Override
    public int getItemCount() {
        return tema12s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt12_titulo,tvt12_descripcion;
        ImageView imaget12;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt12_titulo = (TextView) itemView.findViewById(R.id.tvt12_titulo);
            tvt12_descripcion = (TextView) itemView.findViewById(R.id.tvt12_descripcion);

            imaget12 = (ImageView) itemView.findViewById(R.id.imaget12);
        }
    }
}
