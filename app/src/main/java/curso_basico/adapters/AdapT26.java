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

import curso_basico.temas.Tema_26;

public class AdapT26 extends RecyclerView.Adapter<AdapT26.MyViewHolder> {

    Context context;
    ArrayList<Tema_26> tema26s;

    public AdapT26 (Context c, ArrayList<Tema_26> tm26){
        context = c;
        tema26s = tm26;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema26,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt26_titulo.setText(tema26s.get(position).getTitulo26());
        holder.tvt26_descripcion.setText(tema26s.get(position).getDescripcion26());

        Glide.with(context)
                .load(tema26s.get(position).getImagen26())
                .into(holder.imaget26);
    }

    @Override
    public int getItemCount() {
        return tema26s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt26_titulo, tvt26_descripcion;
        ImageView imaget26;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt26_titulo = (TextView) itemView.findViewById(R.id.tvt26_titulo);
            tvt26_descripcion = (TextView) itemView.findViewById(R.id.tvt26_descripcion);

            imaget26 = (ImageView) itemView.findViewById(R.id.imaget26);
        }
    }
}
