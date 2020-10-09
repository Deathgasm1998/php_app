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

import curso_basico.temas.Tema_23;

public class AdapT23 extends RecyclerView.Adapter<AdapT23.MyViewHolder> {

    Context context;
    ArrayList<Tema_23> tema23s;

    public AdapT23 (Context c, ArrayList<Tema_23> tm23){
        context = c;
        tema23s = tm23;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema23,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt23_titulo.setText(tema23s.get(position).getTitulo23());
        holder.tvt23_descripcion.setText(tema23s.get(position).getDescripcion23());

        Glide.with(context)
                .load(tema23s.get(position).getImagen23())
                .into(holder.imaget23);
    }

    @Override
    public int getItemCount() {
        return tema23s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt23_titulo, tvt23_descripcion;
        ImageView imaget23;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt23_titulo = (TextView) itemView.findViewById(R.id.tvt23_titulo);
            tvt23_descripcion = (TextView) itemView.findViewById(R.id.tvt23_descripcion);

            imaget23 = (ImageView) itemView.findViewById(R.id.imaget23);
        }
    }
}
