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

import curso_avanzado.temas.Temava_8;

public class AdapAV8 extends RecyclerView.Adapter<AdapAV8.MyViewHolder> {
    Context context;
    ArrayList<Temava_8> tema8s;

    public AdapAV8 (Context c, ArrayList<Temava_8> tm8){
        context = c;
        tema8s = tm8;
    }


    @NonNull
    @Override
    public AdapAV8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV8.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava8,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV8.MyViewHolder holder, int position) {

        holder.tvta8_titulo.setText(tema8s.get(position).getTitulo8a());
        holder.tvta8_descripcion.setText(tema8s.get(position).getDescripcion8a());

        Glide.with(context)
                .load(tema8s.get(position).getImagen8a())
                .into(holder.imageta8);
    }

    @Override
    public int getItemCount() {
        return tema8s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta8_titulo,tvta8_descripcion;
        ImageView imageta8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta8_titulo = (TextView) itemView.findViewById(R.id.tvta8_titulo);
            tvta8_descripcion = (TextView) itemView.findViewById(R.id.tvta8_descripcion);

            imageta8 = (ImageView) itemView.findViewById(R.id.imageta8);

        }
    }
}
