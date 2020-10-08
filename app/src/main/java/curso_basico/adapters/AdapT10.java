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
import curso_basico.temas.Tema_10;

import java.util.ArrayList;


public class AdapT10 extends RecyclerView.Adapter<AdapT10.MyViewHolder> {

    Context context;
    ArrayList<Tema_10> tema10s;

    public  AdapT10 (Context c,ArrayList<Tema_10> tm10){
        context = c;
        tema10s = tm10;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema10,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt10_titulo.setText(tema10s.get(position).getTitulo10());
        holder.tvt10_descripcion.setText(tema10s.get(position).getDescripcion10());

        Glide.with(context)
                .load(tema10s.get(position).getImagen10())
                .into(holder.imaget10);


    }

    @Override
    public int getItemCount() {
        return tema10s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt10_titulo,tvt10_descripcion;
        ImageView imaget10;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt10_titulo = (TextView) itemView.findViewById(R.id.tvt10_titulo);
            tvt10_descripcion = (TextView) itemView.findViewById(R.id.tvt10_descripcion);

            imaget10 = (ImageView) itemView.findViewById(R.id.imaget10);
        }
    }
}
