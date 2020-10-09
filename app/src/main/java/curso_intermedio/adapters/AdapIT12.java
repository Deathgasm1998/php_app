package curso_intermedio.adapters;

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

import curso_intermedio.temas.Temain_12;

public class AdapIT12 extends RecyclerView.Adapter<AdapIT12.MyViewHolder> {
    Context context;
    ArrayList<Temain_12> tema12s;

    public AdapIT12 (Context c, ArrayList<Temain_12> tm12){
        context = c;
        tema12s = tm12;
    }


    @NonNull
    @Override
    public AdapIT12.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT12.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter12,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT12.MyViewHolder holder, int position) {

        holder.tvti12_titulo.setText(tema12s.get(position).getTitulo12i());
        holder.tvti12_descripcion.setText(tema12s.get(position).getDescripcion12i());

        Glide.with(context)
                .load(tema12s.get(position).getImagen12i())
                .into(holder.imageti12);
    }

    @Override
    public int getItemCount() {
        return tema12s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti12_titulo,tvti12_descripcion;
        ImageView imageti12;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti12_titulo = (TextView) itemView.findViewById(R.id.tvti12_titulo);
            tvti12_descripcion = (TextView) itemView.findViewById(R.id.tvti12_descripcion);

            imageti12 = (ImageView) itemView.findViewById(R.id.imageti12);

        }
    }
}

