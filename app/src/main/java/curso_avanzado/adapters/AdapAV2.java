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

import curso_avanzado.temas.Temava_2;

public class AdapAV2 extends RecyclerView.Adapter<AdapAV2.MyViewHolder> {
    Context context;
    ArrayList<Temava_2> tema2s;

    public AdapAV2 (Context c, ArrayList<Temava_2> tm2){
        context = c;
        tema2s = tm2;
    }


    @NonNull
    @Override
    public AdapAV2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV2.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV2.MyViewHolder holder, int position) {

        holder.tvta2_titulo.setText(tema2s.get(position).getTitulo2a());
        holder.tvta2_descripcion.setText(tema2s.get(position).getDescripcion2a());

        Glide.with(context)
                .load(tema2s.get(position).getImagen2a())
                .into(holder.imageta2);
    }

    @Override
    public int getItemCount() {
        return tema2s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta2_titulo,tvta2_descripcion;
        ImageView imageta2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta2_titulo = (TextView) itemView.findViewById(R.id.tvta2_titulo);
            tvta2_descripcion = (TextView) itemView.findViewById(R.id.tvta2_descripcion);

            imageta2 = (ImageView) itemView.findViewById(R.id.imageta2);

        }
    }
}
