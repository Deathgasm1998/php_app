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
import curso_intermedio.temas.Temain_7;

import java.util.ArrayList;

public class AdapIT7 extends RecyclerView.Adapter<AdapIT7.MyViewHolder> {
    Context context;
    ArrayList<Temain_7> tema7s;

    public AdapIT7 (Context c, ArrayList<Temain_7> tm7){
        context = c;
        tema7s = tm7;
    }


    @NonNull
    @Override
    public AdapIT7.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT7.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter7,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT7.MyViewHolder holder, int position) {

        holder.tvti7_titulo.setText(tema7s.get(position).getTitulo7i());
        holder.tvti7_descripcion.setText(tema7s.get(position).getDescripcion7i());

        Glide.with(context)
                .load(tema7s.get(position).getImagen7i())
                .into(holder.imageti7);
    }

    @Override
    public int getItemCount() {
        return tema7s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti7_titulo,tvti7_descripcion;
        ImageView imageti7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti7_titulo = (TextView) itemView.findViewById(R.id.tvti7_titulo);
            tvti7_descripcion = (TextView) itemView.findViewById(R.id.tvti7_descripcion);

            imageti7 = (ImageView) itemView.findViewById(R.id.imageti7);

        }
    }
}

