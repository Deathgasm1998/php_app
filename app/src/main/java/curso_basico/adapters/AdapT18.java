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

import curso_basico.temas.Tema_18;


public class AdapT18 extends RecyclerView.Adapter<AdapT18.MyViewHolder> {

    Context context;
    ArrayList<Tema_18> tema18s;

    public AdapT18(Context c, ArrayList<Tema_18> tm18){
        context = c;
        tema18s = tm18;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema18,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt18_titulo.setText(tema18s.get(position).getTitulo18());
        holder.tvt18_descripcion.setText(tema18s.get(position).getDescripcion18());

        Glide.with(context)
                .load(tema18s.get(position).getImagen18())
                .into(holder.imaget18);


    }

    @Override
    public int getItemCount() {
        return tema18s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt18_titulo,tvt18_descripcion;
        ImageView imaget18;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt18_titulo = (TextView) itemView.findViewById(R.id.tvt18_titulo);
            tvt18_descripcion = (TextView) itemView.findViewById(R.id.tvt18_descripcion);

            imaget18 = (ImageView) itemView.findViewById(R.id.imaget18);
        }
    }
}
