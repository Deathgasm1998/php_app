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

import curso_intermedio.temas.Temain_16;

public class AdapIT16 extends RecyclerView.Adapter<AdapIT16.MyViewHolder> {
    Context context;
    ArrayList<Temain_16> tema16s;

    public AdapIT16 (Context c, ArrayList<Temain_16> tm16){
        context = c;
        tema16s = tm16;
    }


    @NonNull
    @Override
    public AdapIT16.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT16.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter16,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT16.MyViewHolder holder, int position) {

        holder.tvti16_titulo.setText(tema16s.get(position).getTitulo16i());
        holder.tvti16_descripcion.setText(tema16s.get(position).getDescripcion16i());

        Glide.with(context)
                .load(tema16s.get(position).getImagen16i())
                .into(holder.imageti16);
    }

    @Override
    public int getItemCount() {
        return tema16s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti16_titulo,tvti16_descripcion;
        ImageView imageti16;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti16_titulo = (TextView) itemView.findViewById(R.id.tvti16_titulo);
            tvti16_descripcion = (TextView) itemView.findViewById(R.id.tvti16_descripcion);

            imageti16 = (ImageView) itemView.findViewById(R.id.imageti16);

        }
    }
}

