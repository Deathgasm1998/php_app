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

import curso_basico.temas.Tema_4;

public class AdapT4 extends RecyclerView.Adapter<AdapT4.MyViewHolder> {

    Context context;
    ArrayList<Tema_4> tema4s;

    public AdapT4 (Context c, ArrayList<Tema_4> tm4){
        context = c;
        tema4s = tm4;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema4,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt4_titulo.setText(tema4s.get(position).getTitulo4());
        holder.tvt4_descripcion.setText(tema4s.get(position).getDescripcion4());

        Glide.with(context)
                .load(tema4s.get(position).getImagen4())
                .into(holder.imaget4);
    }

    @Override
    public int getItemCount() {
        return tema4s.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvt4_titulo,tvt4_descripcion;
        ImageView imaget4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt4_titulo = (TextView) itemView.findViewById(R.id.tvt4_titulo);
            tvt4_descripcion = (TextView) itemView.findViewById(R.id.tvt4_descripcion);

            imaget4 = (ImageView) itemView.findViewById(R.id.imaget4);
        }
    }
}
