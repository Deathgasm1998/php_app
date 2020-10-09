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

import curso_basico.temas.Tema_27;

public class AdapT27 extends RecyclerView.Adapter<AdapT27.MyViewHolder> {
    Context context;
    ArrayList<Tema_27> tema27s;

    public AdapT27 (Context c, ArrayList<Tema_27> tm27){
        context = c;
        tema27s = tm27;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema27,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt27_titulo.setText(tema27s.get(position).getTitulo27());
        holder.tvt27_descripcion.setText(tema27s.get(position).getDescripcion27());

        Glide.with(context)
                .load(tema27s.get(position).getImagen27())
                .into(holder.imaget27);
    }

    @Override
    public int getItemCount() {
        return tema27s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt27_titulo, tvt27_descripcion;
        ImageView imaget27;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt27_titulo = (TextView) itemView.findViewById(R.id.tvt27_titulo);
            tvt27_descripcion = (TextView) itemView.findViewById(R.id.tvt27_descripcion);

            imaget27 = (ImageView) itemView.findViewById(R.id.imaget27);
        }
    }
}
