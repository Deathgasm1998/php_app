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

import curso_intermedio.temas.Temain_14;

public class AdapIT14 extends RecyclerView.Adapter<AdapIT14.MyViewHolder> {
    Context context;
    ArrayList<Temain_14> tema14s;

    public AdapIT14 (Context c, ArrayList<Temain_14> tm14){
        context = c;
        tema14s = tm14;
    }


    @NonNull
    @Override
    public AdapIT14.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT14.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter14,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT14.MyViewHolder holder, int position) {

        holder.tvti14_titulo.setText(tema14s.get(position).getTitulo14i());
        holder.tvti14_descripcion.setText(tema14s.get(position).getDescripcion14i());

        Glide.with(context)
                .load(tema14s.get(position).getImagen14i())
                .into(holder.imageti14);
    }

    @Override
    public int getItemCount() {
        return tema14s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti14_titulo,tvti14_descripcion;
        ImageView imageti14;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti14_titulo = (TextView) itemView.findViewById(R.id.tvti14_titulo);
            tvti14_descripcion = (TextView) itemView.findViewById(R.id.tvti14_descripcion);

            imageti14 = (ImageView) itemView.findViewById(R.id.imageti14);

        }
    }
}

