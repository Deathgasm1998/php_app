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
import curso_intermedio.temas.Temain_8;

import java.util.ArrayList;

public class AdapIT8 extends RecyclerView.Adapter<AdapIT8.MyViewHolder> {
    Context context;
    ArrayList<Temain_8> tema8s;

    public AdapIT8 (Context c, ArrayList<Temain_8> tm8){
        context = c;
        tema8s = tm8;
    }


    @NonNull
    @Override
    public AdapIT8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT8.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter8,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT8.MyViewHolder holder, int position) {

        holder.tvti8_titulo.setText(tema8s.get(position).getTitulo8i());
        holder.tvti8_descripcion.setText(tema8s.get(position).getDescripcion8i());

        Glide.with(context)
                .load(tema8s.get(position).getImagen8i())
                .into(holder.imageti8);
    }

    @Override
    public int getItemCount() {
        return tema8s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti8_titulo,tvti8_descripcion;
        ImageView imageti8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti8_titulo = (TextView) itemView.findViewById(R.id.tvti8_titulo);
            tvti8_descripcion = (TextView) itemView.findViewById(R.id.tvti8_descripcion);

            imageti8 = (ImageView) itemView.findViewById(R.id.imageti8);

        }
    }
}

