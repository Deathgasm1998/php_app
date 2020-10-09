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

import curso_basico.temas.Tema_20;

import java.util.ArrayList;

public class AdapT20 extends RecyclerView.Adapter<AdapT20.MyViewHolder> {

    Context context;
    ArrayList<Tema_20> tema20s;

    public AdapT20 (Context c, ArrayList<Tema_20> tm20){
        context = c;
        tema20s = tm20;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema20,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt20_titulo.setText(tema20s.get(position).getTitulo20());
        holder.tvt20_descripcion.setText(tema20s.get(position).getDescripcion20());

        Glide.with(context)
                .load(tema20s.get(position).getImagen20())
                .into(holder.imaget20);
    }

    @Override
    public int getItemCount() {
        return tema20s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt20_titulo,tvt20_descripcion;
        ImageView imaget20;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt20_titulo = (TextView) itemView.findViewById(R.id.tvt20_titulo);
            tvt20_descripcion = (TextView) itemView.findViewById(R.id.tvt20_descripcion);

            imaget20 = (ImageView) itemView.findViewById(R.id.imaget20);
        }
    }
}