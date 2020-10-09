package curso_basico.adapters;

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

import curso_basico.temas.Tema_19;


public class AdapT19 extends RecyclerView.Adapter<AdapT19.MyViewHolder> {

    Context context;
    ArrayList<Tema_19> tema19s;

    public AdapT19(Context c, ArrayList<Tema_19> tm19){
        context = c;
        tema19s = tm19;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema19,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt19_titulo.setText(tema19s.get(position).getTitulo19());
        holder.tvt19_descripcion.setText(tema19s.get(position).getDescripcion19());

        Glide.with(context)
                .load(tema19s.get(position).getImagen19())
                .into(holder.imaget19);


    }

    @Override
    public int getItemCount() {
        return tema19s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt19_titulo,tvt19_descripcion;
        ImageView imaget19;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt19_titulo = (TextView) itemView.findViewById(R.id.tvt19_titulo);
            tvt19_descripcion = (TextView) itemView.findViewById(R.id.tvt19_descripcion);

            imaget19 = (ImageView) itemView.findViewById(R.id.imaget19);
        }
    }
}
