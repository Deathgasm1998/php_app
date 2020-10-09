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
import curso_intermedio.temas.Temain_20;

import java.util.ArrayList;

public class AdapIT20 extends RecyclerView.Adapter<AdapIT20.MyViewHolder> {
    Context context;
    ArrayList<Temain_20> tema20s;

    public AdapIT20 (Context c, ArrayList<Temain_20> tm20){
        context = c;
        tema20s = tm20;
    }


    @NonNull
    @Override
    public AdapIT20.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT20.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter20,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT20.MyViewHolder holder, int position) {

        holder.tvti20_titulo.setText(tema20s.get(position).getTitulo20i());
        holder.tvti20_descripcion.setText(tema20s.get(position).getDescripcion20i());

        Glide.with(context)
                .load(tema20s.get(position).getImagen20i())
                .into(holder.imageti20);
    }

    @Override
    public int getItemCount() {
        return tema20s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti20_titulo,tvti20_descripcion;
        ImageView imageti20;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti20_titulo = (TextView) itemView.findViewById(R.id.tvti20_titulo);
            tvti20_descripcion = (TextView) itemView.findViewById(R.id.tvti20_descripcion);

            imageti20 = (ImageView) itemView.findViewById(R.id.imageti20);

        }
    }
}

