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

import curso_intermedio.temas.Temain_11;

public class AdapIT11 extends RecyclerView.Adapter<AdapIT11.MyViewHolder> {
    Context context;
    ArrayList<Temain_11> tema11s;

    public AdapIT11 (Context c, ArrayList<Temain_11> tm11){
        context = c;
        tema11s = tm11;
    }


    @NonNull
    @Override
    public AdapIT11.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT11.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter11,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT11.MyViewHolder holder, int position) {

        holder.tvti11_titulo.setText(tema11s.get(position).getTitulo11i());
        holder.tvti11_descripcion.setText(tema11s.get(position).getDescripcion11i());

        Glide.with(context)
                .load(tema11s.get(position).getImagen11i())
                .into(holder.imageti11);
    }

    @Override
    public int getItemCount() {
        return tema11s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti11_titulo,tvti11_descripcion;
        ImageView imageti11;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti11_titulo = (TextView) itemView.findViewById(R.id.tvti11_titulo);
            tvti11_descripcion = (TextView) itemView.findViewById(R.id.tvti11_descripcion);

            imageti11 = (ImageView) itemView.findViewById(R.id.imageti11);

        }
    }
}

