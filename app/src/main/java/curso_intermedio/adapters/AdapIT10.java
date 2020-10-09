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

import curso_intermedio.temas.Temain_10;

public class AdapIT10 extends RecyclerView.Adapter<AdapIT10.MyViewHolder> {
    Context context;
    ArrayList<Temain_10> tema10s;

    public AdapIT10 (Context c, ArrayList<Temain_10> tm10){
        context = c;
        tema10s = tm10;
    }


    @NonNull
    @Override
    public AdapIT10.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT10.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter10,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT10.MyViewHolder holder, int position) {

        holder.tvti10_titulo.setText(tema10s.get(position).getTitulo10i());
        holder.tvti10_descripcion.setText(tema10s.get(position).getDescripcion10i());

        Glide.with(context)
                .load(tema10s.get(position).getImagen10i())
                .into(holder.imageti10);
    }

    @Override
    public int getItemCount() {
        return tema10s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti10_titulo,tvti10_descripcion;
        ImageView imageti10;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti10_titulo = (TextView) itemView.findViewById(R.id.tvti10_titulo);
            tvti10_descripcion = (TextView) itemView.findViewById(R.id.tvti10_descripcion);

            imageti10 = (ImageView) itemView.findViewById(R.id.imageti10);

        }
    }
}

