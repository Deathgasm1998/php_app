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

import curso_basico.temas.Tema_6;

public class AdapT6 extends RecyclerView.Adapter<AdapT6.MyViewHolder> {

    Context context;
    ArrayList<Tema_6> tema6s;

    public AdapT6 (Context c, ArrayList<Tema_6> tm6){
        context = c;
        tema6s=tm6;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema6,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvt6_titulo.setText(tema6s.get(position).getTitulo6());
        holder.tvt6_descripcion.setText(tema6s.get(position).getDescripcion6());

        Glide.with(context)
                .load(tema6s.get(position).getImage6())
                .into(holder.imaget6);

    }

    @Override
    public int getItemCount() {
        return tema6s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt6_titulo, tvt6_descripcion;
        ImageView imaget6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt6_titulo = (TextView) itemView.findViewById(R.id.tvt6_titulo);
            tvt6_descripcion = (TextView) itemView.findViewById(R.id.tvt6_descripcion);

            imaget6 = (ImageView) itemView.findViewById(R.id.imaget6);

        }
    }
}
