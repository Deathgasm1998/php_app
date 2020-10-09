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

import curso_intermedio.temas.Temain_19;

public class AdapIT19 extends RecyclerView.Adapter<AdapIT19.MyViewHolder> {
    Context context;
    ArrayList<Temain_19> tema19s;

    public AdapIT19 (Context c, ArrayList<Temain_19> tm19){
        context = c;
        tema19s = tm19;
    }


    @NonNull
    @Override
    public AdapIT19.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT19.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter19,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT19.MyViewHolder holder, int position) {

        holder.tvti19_titulo.setText(tema19s.get(position).getTitulo19i());
        holder.tvti19_descripcion.setText(tema19s.get(position).getDescripcion19i());

        Glide.with(context)
                .load(tema19s.get(position).getImagen19i())
                .into(holder.imageti19);
    }

    @Override
    public int getItemCount() {
        return tema19s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti19_titulo,tvti19_descripcion;
        ImageView imageti19;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti19_titulo = (TextView) itemView.findViewById(R.id.tvti19_titulo);
            tvti19_descripcion = (TextView) itemView.findViewById(R.id.tvti19_descripcion);

            imageti19 = (ImageView) itemView.findViewById(R.id.imageti19);

        }
    }
}

