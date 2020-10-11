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

import curso_avanzado.temas.Temava_1;

public class AdapAV1 extends RecyclerView.Adapter<AdapAV1.MyViewHolder> {
    Context context;
    ArrayList<Temava_1> tema1s;

    public AdapAV1 (Context c, ArrayList<Temava_1> tm1){
        context = c;
        tema1s = tm1;
    }


    @NonNull
    @Override
    public AdapAV1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV1.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV1.MyViewHolder holder, int position) {

        holder.tvta1_titulo.setText(tema1s.get(position).getTitulo1a());
        holder.tvta1_descripcion.setText(tema1s.get(position).getDescripcion1a());

        Glide.with(context)
                .load(tema1s.get(position).getImagen1a())
                .into(holder.imageta1);
    }

    @Override
    public int getItemCount() {
        return tema1s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta1_titulo,tvta1_descripcion;
        ImageView imageta1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta1_titulo = (TextView) itemView.findViewById(R.id.tvta1_titulo);
            tvta1_descripcion = (TextView) itemView.findViewById(R.id.tvta1_descripcion);

            imageta1 = (ImageView) itemView.findViewById(R.id.imageta1);

        }
    }
}



