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

import curso_basico.temas.Tema_30;

public class AdapT30 extends RecyclerView.Adapter<AdapT30.MyViewHolder> {

    Context context;
    ArrayList<Tema_30> tema30s;

    public AdapT30 (Context c, ArrayList<Tema_30> tm30){
        context = c;
        tema30s = tm30;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema30,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt30_titulo.setText(tema30s.get(position).getTitulo30());
        holder.tvt30_descripcion.setText(tema30s.get(position).getDescripcion30());

        Glide.with(context)
                .load(tema30s.get(position).getImagen30())
                .into(holder.imaget30);
    }

    @Override
    public int getItemCount() {
        return tema30s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt30_titulo, tvt30_descripcion;
        ImageView imaget30;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt30_titulo = (TextView) itemView.findViewById(R.id.tvt30_titulo);
            tvt30_descripcion = (TextView) itemView.findViewById(R.id.tvt30_descripcion);

            imaget30 = (ImageView) itemView.findViewById(R.id.imaget30);
        }
    }
}
