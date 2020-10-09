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

import curso_intermedio.temas.Temain_15;

public class AdapIT15 extends RecyclerView.Adapter<AdapIT15.MyViewHolder> {
    Context context;
    ArrayList<Temain_15> tema15s;

    public AdapIT15 (Context c, ArrayList<Temain_15> tm15){
        context = c;
        tema15s = tm15;
    }


    @NonNull
    @Override
    public AdapIT15.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT15.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter15,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT15.MyViewHolder holder, int position) {

        holder.tvti15_titulo.setText(tema15s.get(position).getTitulo15i());
        holder.tvti15_descripcion.setText(tema15s.get(position).getDescripcion15i());

        Glide.with(context)
                .load(tema15s.get(position).getImagen15i())
                .into(holder.imageti15);
    }

    @Override
    public int getItemCount() {
        return tema15s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti15_titulo,tvti15_descripcion;
        ImageView imageti15;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti15_titulo = (TextView) itemView.findViewById(R.id.tvti15_titulo);
            tvti15_descripcion = (TextView) itemView.findViewById(R.id.tvti15_descripcion);

            imageti15 = (ImageView) itemView.findViewById(R.id.imageti15);

        }
    }
}

