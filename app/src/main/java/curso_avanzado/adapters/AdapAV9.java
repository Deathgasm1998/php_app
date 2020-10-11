package curso_avanzado.adapters;

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

import curso_avanzado.temas.Temava_9;

public class AdapAV9 extends RecyclerView.Adapter<AdapAV9.MyViewHolder> {
    Context context;
    ArrayList<Temava_9> tema9s;

    public AdapAV9 (Context c, ArrayList<Temava_9> tm9){
        context = c;
        tema9s = tm9;
    }


    @NonNull
    @Override
    public AdapAV9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV9.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava9,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV9.MyViewHolder holder, int position) {

        holder.tvta9_titulo.setText(tema9s.get(position).getTitulo9a());
        holder.tvta9_descripcion.setText(tema9s.get(position).getDescripcion9a());

        Glide.with(context)
                .load(tema9s.get(position).getImagen9a())
                .into(holder.imageta9);
    }

    @Override
    public int getItemCount() {
        return tema9s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta9_titulo,tvta9_descripcion;
        ImageView imageta9;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta9_titulo = (TextView) itemView.findViewById(R.id.tvta9_titulo);
            tvta9_descripcion = (TextView) itemView.findViewById(R.id.tvta9_descripcion);

            imageta9 = (ImageView) itemView.findViewById(R.id.imageta9);

        }
    }
}
