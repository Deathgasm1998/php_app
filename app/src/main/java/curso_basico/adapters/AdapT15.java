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
import curso_basico.temas.Tema_15;

import java.util.ArrayList;


public class AdapT15 extends RecyclerView.Adapter<AdapT15.MyViewHolder> {

    Context context;
    ArrayList<Tema_15> tema15s;

    public  AdapT15 (Context c,ArrayList<Tema_15> tm15){
        context = c;
        tema15s = tm15;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema15,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt15_titulo.setText(tema15s.get(position).getTitulo15());
        holder.tvt15_descripcion.setText(tema15s.get(position).getDescripcion15());

        Glide.with(context)
                .load(tema15s.get(position).getImagen15())
                .into(holder.imaget15);


    }

    @Override
    public int getItemCount() {
        return tema15s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt15_titulo,tvt15_descripcion;
        ImageView imaget15;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt15_titulo = (TextView) itemView.findViewById(R.id.tvt15_titulo);
            tvt15_descripcion = (TextView) itemView.findViewById(R.id.tvt15_descripcion);

            imaget15 = (ImageView) itemView.findViewById(R.id.imaget15);
        }
    }
}