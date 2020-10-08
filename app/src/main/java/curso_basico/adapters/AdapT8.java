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

import curso_basico.temas.Tema_8;

public class AdapT8 extends RecyclerView.Adapter<AdapT8.MyViewHolder> {

   Context context;
   ArrayList<Tema_8> tema8s;

   public AdapT8 (Context c, ArrayList<Tema_8> tm8){
       context = c;
       tema8s = tm8;
   }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema8,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt8_titulo.setText(tema8s.get(position).getTitulo8());
        holder.tvt8_descripcion.setText(tema8s.get(position).getDescripcion8());

        Glide.with(context)
                .load(tema8s.get(position).getImage8())
                .into(holder.imaget8);
    }

    @Override
    public int getItemCount() {
        return tema8s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt8_titulo, tvt8_descripcion;
        ImageView imaget8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt8_titulo = (TextView) itemView.findViewById(R.id.tvt8_titulo);
            tvt8_descripcion = (TextView) itemView.findViewById(R.id.tvt8_descripcion);

            imaget8 = (ImageView) itemView.findViewById(R.id.imaget8);
        }
    }
}
