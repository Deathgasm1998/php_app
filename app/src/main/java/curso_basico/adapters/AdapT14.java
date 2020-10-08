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
import curso_basico.temas.Tema_14;

import java.util.ArrayList;


public class AdapT14 extends RecyclerView.Adapter<AdapT14.MyViewHolder> {

    Context context;
    ArrayList<Tema_14> tema14s;

    public  AdapT14 (Context c,ArrayList<Tema_14> tm14){
        context = c;
        tema14s = tm14;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema14,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt14_titulo.setText(tema14s.get(position).getTitulo14());
        holder.tvt14_descripcion.setText(tema14s.get(position).getDescripcion14());

        Glide.with(context)
                .load(tema14s.get(position).getImagen14())
                .into(holder.imaget14);


    }

    @Override
    public int getItemCount() {
        return tema14s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt14_titulo,tvt14_descripcion;
        ImageView imaget14;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt14_titulo = (TextView) itemView.findViewById(R.id.tvt14_titulo);
            tvt14_descripcion = (TextView) itemView.findViewById(R.id.tvt14_descripcion);

            imaget14 = (ImageView) itemView.findViewById(R.id.imaget14);
        }
    }
}