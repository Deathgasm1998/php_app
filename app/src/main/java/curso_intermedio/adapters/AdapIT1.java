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

import curso_intermedio.temas.Temain_1;

public class AdapIT1 extends RecyclerView.Adapter<AdapIT1.MyViewHolder> {
    Context context;
    ArrayList<Temain_1> tema1s;

    public AdapIT1 (Context c, ArrayList<Temain_1> tm1){
        context = c;
        tema1s = tm1;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT1.MyViewHolder holder, int position) {

        holder.tvti1_titulo.setText(tema1s.get(position).getTitulo1i());
        holder.tvti1_descripcion.setText(tema1s.get(position).getDescripcion1i());

        Glide.with(context)
                .load(tema1s.get(position).getImagen1i())
                .into(holder.imageti1);
    }

    @Override
    public int getItemCount() {
        return tema1s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti1_titulo,tvti1_descripcion;
        ImageView imageti1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti1_titulo = (TextView) itemView.findViewById(R.id.tvti1_titulo);
            tvti1_descripcion = (TextView) itemView.findViewById(R.id.tvti1_descripcion);

            imageti1 = (ImageView) itemView.findViewById(R.id.imageti1);

        }
    }
}


