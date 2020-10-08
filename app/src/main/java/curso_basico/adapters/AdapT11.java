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
import curso_basico.temas.Tema_11;

import java.util.ArrayList;


public class AdapT11 extends RecyclerView.Adapter<AdapT11.MyViewHolder> {

    Context context;
    ArrayList<Tema_11> tema11s;

    public  AdapT11 (Context c,ArrayList<Tema_11> tm11){
        context = c;
        tema11s = tm11;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema11,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt11_titulo.setText(tema11s.get(position).getTitulo11());
        holder.tvt11_descripcion.setText(tema11s.get(position).getDescripcion11());

        Glide.with(context)
                .load(tema11s.get(position).getImagen11())
                .into(holder.imaget11);


    }

    @Override
    public int getItemCount() {
        return tema11s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt11_titulo,tvt11_descripcion;
        ImageView imaget11;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt11_titulo = (TextView) itemView.findViewById(R.id.tvt11_titulo);
            tvt11_descripcion = (TextView) itemView.findViewById(R.id.tvt11_descripcion);

            imaget11 = (ImageView) itemView.findViewById(R.id.imaget11);
        }
    }
}
