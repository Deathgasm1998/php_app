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

import curso_basico.temas.Tema_21;

public class AdapT21 extends RecyclerView.Adapter<AdapT21.MyViewHolder> {

    Context context;
    ArrayList<Tema_21> tema21s;

    public AdapT21 (Context c, ArrayList<Tema_21> tm21){
        context = c;
        tema21s = tm21;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema21,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt21_titulo.setText(tema21s.get(position).getTitulo21());
        holder.tvt21_descripcion.setText(tema21s.get(position).getDescripcion21());

        Glide.with(context)
                .load(tema21s.get(position).getImagen21())
                .into(holder.imaget21);
    }

    @Override
    public int getItemCount() {
        return tema21s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt21_titulo,tvt21_descripcion;
        ImageView imaget21;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt21_titulo = (TextView) itemView.findViewById(R.id.tvt21_titulo);
            tvt21_descripcion = (TextView) itemView.findViewById(R.id.tvt21_descripcion);

            imaget21 = (ImageView) itemView.findViewById(R.id.imaget21);
        }
    }
}
