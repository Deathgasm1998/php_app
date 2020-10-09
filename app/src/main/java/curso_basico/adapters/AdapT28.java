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

import curso_basico.temas.Tema_28;

public class AdapT28 extends RecyclerView.Adapter<AdapT28.MyViewHolder> {
    Context context;
    ArrayList<Tema_28> tema28s;

    public AdapT28 (Context c, ArrayList<Tema_28> tm28){
        context = c;
        tema28s = tm28;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema28,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt28_titulo.setText(tema28s.get(position).getTitulo28());
        holder.tvt28_descripcion.setText(tema28s.get(position).getDescripcion28());

        Glide.with(context)
                .load(tema28s.get(position).getImagen28())
                .into(holder.imaget28);
    }

    @Override
    public int getItemCount() {
        return tema28s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt28_titulo, tvt28_descripcion;
        ImageView imaget28;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt28_titulo = (TextView) itemView.findViewById(R.id.tvt28_titulo);
            tvt28_descripcion = (TextView) itemView.findViewById(R.id.tvt28_descripcion);

            imaget28 = (ImageView) itemView.findViewById(R.id.imaget28);
        }
    }

}
