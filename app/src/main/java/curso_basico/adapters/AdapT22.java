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

import curso_basico.temas.Tema_22;

public class AdapT22 extends RecyclerView.Adapter<AdapT22.MyViewHolder> {
    Context context;
    ArrayList<Tema_22> tema22s;

    public AdapT22 (Context c, ArrayList<Tema_22> tm22){
        context = c;
        tema22s = tm22;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema22,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt22_titulo.setText(tema22s.get(position).getTitulo22());
        holder.tvt22_descripcion.setText(tema22s.get(position).getDescripcion22());

        Glide.with(context)
                .load(tema22s.get(position).getImagen22())
                .into(holder.imaget22);
    }

    @Override
    public int getItemCount() {
        return tema22s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt22_titulo, tvt22_descripcion;
        ImageView imaget22;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt22_titulo = (TextView) itemView.findViewById(R.id.tvt22_titulo);
            tvt22_descripcion = (TextView) itemView.findViewById(R.id.tvt22_descripcion);

            imaget22 = (ImageView) itemView.findViewById(R.id.imaget22);
        }
    }
}
