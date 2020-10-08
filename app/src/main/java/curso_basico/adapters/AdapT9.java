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
import curso_basico.temas.Tema_9;

import java.util.ArrayList;




public class AdapT9 extends RecyclerView.Adapter<AdapT9.MyViewHolder> {

    Context context;
    ArrayList<Tema_9> tema9s;

    public AdapT9 (Context c, ArrayList<Tema_9> tm9){
        context = c;
        tema9s = tm9;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema9,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt9_titulo.setText(tema9s.get(position).getTitulo9());
        holder.tvt9_descripcion.setText(tema9s.get(position).getDescripcion9());

        Glide.with(context)
                .load(tema9s.get(position).getImagen9())
                .into(holder.imaget9);
    }

    @Override
    public int getItemCount() {
        return tema9s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt9_titulo,tvt9_descripcion;
        ImageView imaget9;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt9_titulo = (TextView) itemView.findViewById(R.id.tvt9_titulo);
            tvt9_descripcion = (TextView) itemView.findViewById(R.id.tvt9_descripcion);

            imaget9 = (ImageView) itemView.findViewById(R.id.imaget9);
        }
    }
}
