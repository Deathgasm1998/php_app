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

import curso_intermedio.temas.Temain_13;

public class AdapIT13 extends RecyclerView.Adapter<AdapIT13.MyViewHolder> {
    Context context;
    ArrayList<Temain_13> tema13s;

    public AdapIT13 (Context c, ArrayList<Temain_13> tm13){
        context = c;
        tema13s = tm13;
    }


    @NonNull
    @Override
    public AdapIT13.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT13.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter13,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT13.MyViewHolder holder, int position) {

        holder.tvti13_titulo.setText(tema13s.get(position).getTitulo13i());
        holder.tvti13_descripcion.setText(tema13s.get(position).getDescripcion13i());

        Glide.with(context)
                .load(tema13s.get(position).getImagen13i())
                .into(holder.imageti13);
    }

    @Override
    public int getItemCount() {
        return tema13s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti13_titulo,tvti13_descripcion;
        ImageView imageti13;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti13_titulo = (TextView) itemView.findViewById(R.id.tvti13_titulo);
            tvti13_descripcion = (TextView) itemView.findViewById(R.id.tvti13_descripcion);

            imageti13 = (ImageView) itemView.findViewById(R.id.imageti13);

        }
    }
}

