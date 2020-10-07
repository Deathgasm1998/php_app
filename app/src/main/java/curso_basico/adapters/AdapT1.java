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

import curso_basico.temas.Tema_1;

public class AdapT1 extends RecyclerView.Adapter<AdapT1.MyViewHolder> {

    Context context;
    ArrayList<Tema_1> tema1s;
    public AdapT1 (Context c, ArrayList<Tema_1> tm1){
        context = c;
        tema1s = tm1;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt1_titulo.setText(tema1s.get(position).getTitulo());
        holder.tvt1_descripcion.setText(tema1s.get(position).getDescripcion());

        Glide.with(context)
                .load(tema1s.get(position).getImagen())
                .into(holder.imaget1);
    }

    @Override
    public int getItemCount() {
        return tema1s.size();
    }

/////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvt1_titulo,tvt1_descripcion;
        ImageView imaget1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt1_titulo = (TextView) itemView.findViewById(R.id.tvt1_titulo);
            tvt1_descripcion = (TextView) itemView.findViewById(R.id.tvt1_descripcion);

            imaget1 = (ImageView) itemView.findViewById(R.id.imaget1);

        }
    }
}
