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
import curso_intermedio.temas.Temain_9;

import java.util.ArrayList;

public class AdapIT9 extends RecyclerView.Adapter<AdapIT9.MyViewHolder> {
    Context context;
    ArrayList<Temain_9> tema9s;

    public AdapIT9 (Context c, ArrayList<Temain_9> tm9){
        context = c;
        tema9s = tm9;
    }


    @NonNull
    @Override
    public AdapIT9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT9.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter9,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT9.MyViewHolder holder, int position) {

        holder.tvti9_titulo.setText(tema9s.get(position).getTitulo9i());
        holder.tvti9_descripcion.setText(tema9s.get(position).getDescripcion9i());

        Glide.with(context)
                .load(tema9s.get(position).getImagen9i())
                .into(holder.imageti9);
    }

    @Override
    public int getItemCount() {
        return tema9s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti9_titulo,tvti9_descripcion;
        ImageView imageti9;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti9_titulo = (TextView) itemView.findViewById(R.id.tvti9_titulo);
            tvti9_descripcion = (TextView) itemView.findViewById(R.id.tvti9_descripcion);

            imageti9 = (ImageView) itemView.findViewById(R.id.imageti9);

        }
    }
}

