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

import java.util.ArrayList;

import curso_basico.temas.Tema_3;

public class AdatT3 extends RecyclerView.Adapter<AdatT3.MyViewHolder> {

    Context context;
    ArrayList<Tema_3> tema3s;

    public AdatT3 (Context c, ArrayList<Tema_3> tm3){
        context = c;
        tema3s = tm3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema3,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt3_titulo.setText(tema3s.get(position).getTitulo3());
        holder.tvt3_descripcion.setText(tema3s.get(position).getDescripcion3());

        Glide.with(context)
                .load(tema3s.get(position).getImagen3())
                .into(holder.imaget3);
    }

    @Override
    public int getItemCount() {
        return tema3s.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt3_titulo,tvt3_descripcion;
        ImageView imaget3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt3_titulo = (TextView) itemView.findViewById(R.id.tvt3_titulo);
            tvt3_descripcion = (TextView) itemView.findViewById(R.id.tvt3_descripcion);

            imaget3 = (ImageView) itemView.findViewById(R.id.imaget3);
        }
    }
}
