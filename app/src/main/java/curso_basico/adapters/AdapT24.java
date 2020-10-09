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

import curso_basico.temas.Tema_24;

public class AdapT24 extends RecyclerView.Adapter<AdapT24.MyViewHolder> {
    Context context;
    ArrayList<Tema_24> tema24s;

    public AdapT24 (Context c, ArrayList<Tema_24> tm24){
        context = c;
        tema24s = tm24;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema24,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt24_titulo.setText(tema24s.get(position).getTitulo24());
        holder.tvt24_descripcion.setText(tema24s.get(position).getDescripcion24());

        Glide.with(context)
                .load(tema24s.get(position).getImagen24())
                .into(holder.imaget24);
    }

    @Override
    public int getItemCount() {
        return tema24s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt24_titulo, tvt24_descripcion;
        ImageView imaget24;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt24_titulo = (TextView) itemView.findViewById(R.id.tvt24_titulo);
            tvt24_descripcion = (TextView) itemView.findViewById(R.id.tvt24_descripcion);

            imaget24 = (ImageView) itemView.findViewById(R.id.imaget24);
        }
    }
}
