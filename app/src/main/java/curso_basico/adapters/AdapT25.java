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

import curso_basico.temas.Tema_25;

public class AdapT25 extends RecyclerView.Adapter<AdapT25.MyViewHolder> {

    Context context;
    ArrayList<Tema_25> tema25s;

    public AdapT25 (Context c, ArrayList<Tema_25> tm25){
        context = c;
        tema25s = tm25;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema25,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt25_titulo.setText(tema25s.get(position).getTitulo25());
        holder.tvt25_descripcion.setText(tema25s.get(position).getDescripcion25());

        Glide.with(context)
                .load(tema25s.get(position).getImagen25())
                .into(holder.imaget25);
    }

    @Override
    public int getItemCount() {
         return tema25s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt25_titulo, tvt25_descripcion;
        ImageView imaget25;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt25_titulo = (TextView) itemView.findViewById(R.id.tvt25_titulo);
            tvt25_descripcion = (TextView) itemView.findViewById(R.id.tvt25_descripcion);

            imaget25 = (ImageView) itemView.findViewById(R.id.imaget25);
        }
    }
}
