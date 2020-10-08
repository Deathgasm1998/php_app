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

import curso_basico.temas.Tema_7;

public class AdapT7 extends RecyclerView.Adapter<AdapT7.MyViewHolder> {

    Context context;
    ArrayList<Tema_7> tema7s;

    public AdapT7 (Context c, ArrayList<Tema_7> tm7){
        context = c;
        tema7s=tm7;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema7,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt7_titulo.setText(tema7s.get(position).getTitulo7());
        holder.tvt7_descripcion.setText(tema7s.get(position).getDescripcion7());

        Glide.with(context)
                .load(tema7s.get(position).getImage7())
                .into(holder.imaget7);
    }

    @Override
    public int getItemCount() {
        return tema7s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt7_titulo, tvt7_descripcion;
        ImageView imaget7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt7_titulo = (TextView) itemView.findViewById(R.id.tvt7_titulo);
            tvt7_descripcion = (TextView) itemView.findViewById(R.id.tvt7_descripcion);

            imaget7 = (ImageView) itemView.findViewById(R.id.imaget7);
        }
    }
}



