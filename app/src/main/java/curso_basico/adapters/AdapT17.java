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

import curso_basico.temas.Tema_17;


public class AdapT17 extends RecyclerView.Adapter<AdapT17.MyViewHolder> {

    Context context;
    ArrayList<Tema_17> tema17s;

    public AdapT17(Context c, ArrayList<Tema_17> tm17){
        context = c;
        tema17s = tm17;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tema17,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvt17_titulo.setText(tema17s.get(position).getTitulo17());
        holder.tvt17_descripcion.setText(tema17s.get(position).getDescripcion17());

        Glide.with(context)
                .load(tema17s.get(position).getImagen17())
                .into(holder.imaget17);


    }

    @Override
    public int getItemCount() {
        return tema17s.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvt17_titulo,tvt17_descripcion;
        ImageView imaget17;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt17_titulo = (TextView) itemView.findViewById(R.id.tvt17_titulo);
            tvt17_descripcion = (TextView) itemView.findViewById(R.id.tvt17_descripcion);

            imaget17 = (ImageView) itemView.findViewById(R.id.imaget17);
        }
    }
}
