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

import curso_intermedio.temas.Temain_17;

public class AdapIT17 extends RecyclerView.Adapter<AdapIT17.MyViewHolder> {
    Context context;
    ArrayList<Temain_17> tema17s;

    public AdapIT17 (Context c, ArrayList<Temain_17> tm17){
        context = c;
        tema17s = tm17;
    }


    @NonNull
    @Override
    public AdapIT17.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT17.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter17,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT17.MyViewHolder holder, int position) {

        holder.tvti17_titulo.setText(tema17s.get(position).getTitulo17i());
        holder.tvti17_descripcion.setText(tema17s.get(position).getDescripcion17i());

        Glide.with(context)
                .load(tema17s.get(position).getImagen17i())
                .into(holder.imageti17);
    }

    @Override
    public int getItemCount() {
        return tema17s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti17_titulo,tvti17_descripcion;
        ImageView imageti17;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti17_titulo = (TextView) itemView.findViewById(R.id.tvti17_titulo);
            tvti17_descripcion = (TextView) itemView.findViewById(R.id.tvti17_descripcion);

            imageti17 = (ImageView) itemView.findViewById(R.id.imageti17);

        }
    }
}

