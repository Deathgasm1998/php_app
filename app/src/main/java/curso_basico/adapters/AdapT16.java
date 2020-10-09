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

import curso_basico.temas.Tema_16;


public class AdapT16 extends RecyclerView.Adapter<AdapT16.MyViewHolder> {

    Context context;
    ArrayList<Tema_16> tema16s;

    public  AdapT16 (Context c,ArrayList<Tema_16> tm16){
        context = c;
        tema16s = tm16;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema16,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt16_titulo.setText(tema16s.get(position).getTitulo16());
        holder.tvt16_descripcion.setText(tema16s.get(position).getDescripcion16());

        Glide.with(context)
                .load(tema16s.get(position).getImagen16())
                .into(holder.imaget16);


    }

    @Override
    public int getItemCount() {
        return tema16s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt16_titulo,tvt16_descripcion;
        ImageView imaget16;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt16_titulo = (TextView) itemView.findViewById(R.id.tvt16_titulo);
            tvt16_descripcion = (TextView) itemView.findViewById(R.id.tvt16_descripcion);

            imaget16 = (ImageView) itemView.findViewById(R.id.imaget16);
        }
    }
}
