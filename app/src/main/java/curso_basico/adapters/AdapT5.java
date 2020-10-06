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

import curso_basico.temas.Tema_5;

public class AdapT5 extends RecyclerView.Adapter<AdapT5.MyViewHolder> {

    Context context;
    ArrayList<Tema_5> tema5s;

    public  AdapT5 (Context c,ArrayList<Tema_5> tm5){
        context = c;
        tema5s = tm5;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema5,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt5_titulo.setText(tema5s.get(position).getTitulo5());
        holder.tvt5_descripcion.setText(tema5s.get(position).getDescripcion5());

        Glide.with(context)
                .load(tema5s.get(position).getImagen5())
                .into(holder.imaget5);

    }

    @Override
    public int getItemCount() {
        return tema5s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt5_titulo,tvt5_descripcion;
        ImageView imaget5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt5_titulo = (TextView) itemView.findViewById(R.id.tvt5_titulo);
            tvt5_descripcion = (TextView) itemView.findViewById(R.id.tvt5_descripcion);

            imaget5 = (ImageView) itemView.findViewById(R.id.imaget5);
        }
    }
}
