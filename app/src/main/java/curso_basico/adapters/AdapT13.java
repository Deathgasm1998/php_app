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
import curso_basico.temas.Tema_13;

import java.util.ArrayList;


public class AdapT13 extends RecyclerView.Adapter<AdapT13.MyViewHolder> {

    Context context;
    ArrayList<Tema_13> tema13s;

    public  AdapT13 (Context c,ArrayList<Tema_13> tm13){
        context = c;
        tema13s = tm13;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema13,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt13_titulo.setText(tema13s.get(position).getTitulo13());
        holder.tvt13_descripcion.setText(tema13s.get(position).getDescripcion13());

        Glide.with(context)
                .load(tema13s.get(position).getImagen13())
                .into(holder.imaget13);


    }

    @Override
    public int getItemCount() {
        return tema13s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt13_titulo,tvt13_descripcion;
        ImageView imaget13;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt13_titulo = (TextView) itemView.findViewById(R.id.tvt13_titulo);
            tvt13_descripcion = (TextView) itemView.findViewById(R.id.tvt13_descripcion);

            imaget13 = (ImageView) itemView.findViewById(R.id.imaget13);
        }
    }
}