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

import curso_intermedio.temas.Temain_5;

public class AdapIT5 extends RecyclerView.Adapter<AdapIT5.MyViewHolder> {
    Context context;
    ArrayList<Temain_5> tema5s;

    public AdapIT5 (Context c, ArrayList<Temain_5> tm5){
        context = c;
        tema5s = tm5;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter5,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT5.MyViewHolder holder, int position) {

        holder.tvti5_titulo.setText(tema5s.get(position).getTitulo5i());
        holder.tvti5_descripcion.setText(tema5s.get(position).getDescripcion5i());

        Glide.with(context)
                .load(tema5s.get(position).getImagen5i())
                .into(holder.imageti5);
    }

    @Override
    public int getItemCount() {
        return tema5s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti5_titulo,tvti5_descripcion;
        ImageView imageti5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti5_titulo = (TextView) itemView.findViewById(R.id.tvti5_titulo);
            tvti5_descripcion = (TextView) itemView.findViewById(R.id.tvti5_descripcion);

            imageti5 = (ImageView) itemView.findViewById(R.id.imageti5);

        }
    }

}

