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

import curso_avanzado.temas.Temava_7;

public class AdapAV7 extends RecyclerView.Adapter<AdapAV7.MyViewHolder> {
    Context context;
    ArrayList<Temava_7> tema7s;

    public AdapAV7 (Context c, ArrayList<Temava_7> tm7){
        context = c;
        tema7s = tm7;
    }


    @NonNull
    @Override
    public AdapAV7.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV7.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava7,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV7.MyViewHolder holder, int position) {

        holder.tvta7_titulo.setText(tema7s.get(position).getTitulo7a());
        holder.tvta7_descripcion.setText(tema7s.get(position).getDescripcion7a());

        Glide.with(context)
                .load(tema7s.get(position).getImagen7a())
                .into(holder.imageta7);
    }

    @Override
    public int getItemCount() {
        return tema7s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta7_titulo,tvta7_descripcion;
        ImageView imageta7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta7_titulo = (TextView) itemView.findViewById(R.id.tvta7_titulo);
            tvta7_descripcion = (TextView) itemView.findViewById(R.id.tvta7_descripcion);

            imageta7 = (ImageView) itemView.findViewById(R.id.imageta7);

        }
    }
}
