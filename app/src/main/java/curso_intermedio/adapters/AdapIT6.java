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

import curso_intermedio.temas.Temain_6;

public class AdapIT6 extends RecyclerView.Adapter<AdapIT6.MyViewHolder> {
    Context context;
    ArrayList<Temain_6> tema6s;

    public AdapIT6 (Context c, ArrayList<Temain_6> tm6){
        context = c;
        tema6s = tm6;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter6,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT6.MyViewHolder holder, int position) {

        holder.tvti6_titulo.setText(tema6s.get(position).getTitulo6i());
        holder.tvti6_descripcion.setText(tema6s.get(position).getDescripcion6i());

        Glide.with(context)
                .load(tema6s.get(position).getImagen6i())
                .into(holder.imageti6);
    }

    @Override
    public int getItemCount() {
        return tema6s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti6_titulo,tvti6_descripcion;
        ImageView imageti6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti6_titulo = (TextView) itemView.findViewById(R.id.tvti6_titulo);
            tvti6_descripcion = (TextView) itemView.findViewById(R.id.tvti6_descripcion);

            imageti6 = (ImageView) itemView.findViewById(R.id.imageti6);

        }
    }
}

