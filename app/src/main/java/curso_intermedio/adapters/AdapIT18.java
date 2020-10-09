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

import curso_intermedio.temas.Temain_18;

public class AdapIT18 extends RecyclerView.Adapter<AdapIT18.MyViewHolder> {
    Context context;
    ArrayList<Temain_18> tema18s;

    public AdapIT18 (Context c, ArrayList<Temain_18> tm18){
        context = c;
        tema18s = tm18;
    }


    @NonNull
    @Override
    public AdapIT18.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapIT18.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter18,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT18.MyViewHolder holder, int position) {

        holder.tvti18_titulo.setText(tema18s.get(position).getTitulo18i());
        holder.tvti18_descripcion.setText(tema18s.get(position).getDescripcion18i());

        Glide.with(context)
                .load(tema18s.get(position).getImagen18i())
                .into(holder.imageti18);
    }

    @Override
    public int getItemCount() {
        return tema18s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti18_titulo,tvti18_descripcion;
        ImageView imageti18;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti18_titulo = (TextView) itemView.findViewById(R.id.tvti18_titulo);
            tvti18_descripcion = (TextView) itemView.findViewById(R.id.tvti18_descripcion);

            imageti18 = (ImageView) itemView.findViewById(R.id.imageti18);

        }
    }
}

