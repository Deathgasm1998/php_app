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

import curso_basico.temas.Tema_29;

public class AdapT29 extends RecyclerView.Adapter<AdapT29.MyViewHolder> {

    Context context;
    ArrayList<Tema_29> tema29s;

    public AdapT29 (Context c, ArrayList<Tema_29> tm29){
        context = c;
        tema29s = tm29;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema29,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt29_titulo.setText(tema29s.get(position).getTitulo29());
        holder.tvt29_descripcion.setText(tema29s.get(position).getDescripcion29());

        Glide.with(context)
                .load(tema29s.get(position).getImagen29())
                .into(holder.imaget29);
    }

    @Override
    public int getItemCount() {
        return tema29s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt29_titulo, tvt29_descripcion;
        ImageView imaget29;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt29_titulo = (TextView) itemView.findViewById(R.id.tvt29_titulo);
            tvt29_descripcion = (TextView) itemView.findViewById(R.id.tvt29_descripcion);

            imaget29 = (ImageView) itemView.findViewById(R.id.imaget29);
        }
    }
}
