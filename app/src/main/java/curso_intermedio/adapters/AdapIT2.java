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

import curso_intermedio.temas.Temain_2;

public class AdapIT2 extends RecyclerView.Adapter<AdapIT2.MyViewHolder>{
    Context context;
    ArrayList<Temain_2> tema2s;

    public AdapIT2 (Context c, ArrayList<Temain_2> tm2){
        context = c;
        tema2s = tm2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvti2_titulo.setText(tema2s.get(position).getTitulo2i());
        holder.tvti2_descripcion.setText(tema2s.get(position).getDescripcion2i());

        Glide.with(context)
                .load(tema2s.get(position).getImagen2i())
                .into(holder.imageti2);
    }

    @Override
    public int getItemCount() {
        return tema2s.size();
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti2_titulo,tvti2_descripcion;
        ImageView imageti2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti2_titulo = (TextView) itemView.findViewById(R.id.tvti2_titulo);
            tvti2_descripcion = (TextView) itemView.findViewById(R.id.tvti2_descripcion);

            imageti2 = (ImageView) itemView.findViewById(R.id.imageti2);

        }
    }
}
