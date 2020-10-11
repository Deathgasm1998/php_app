package curso_avanzado.adapters;

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

import curso_avanzado.temas.Temava_5;

public class AdapAV5 extends RecyclerView.Adapter<AdapAV5.MyViewHolder> {
    Context context;
    ArrayList<Temava_5> tema5s;

    public AdapAV5 (Context c, ArrayList<Temava_5> tm5){
        context = c;
        tema5s = tm5;
    }


    @NonNull
    @Override
    public AdapAV5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV5.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava5,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV5.MyViewHolder holder, int position) {

        holder.tvta5_titulo.setText(tema5s.get(position).getTitulo5a());
        holder.tvta5_descripcion.setText(tema5s.get(position).getDescripcion5a());

        Glide.with(context)
                .load(tema5s.get(position).getImagen5a())
                .into(holder.imageta5);
    }

    @Override
    public int getItemCount() {
        return tema5s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta5_titulo,tvta5_descripcion;
        ImageView imageta5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta5_titulo = (TextView) itemView.findViewById(R.id.tvta5_titulo);
            tvta5_descripcion = (TextView) itemView.findViewById(R.id.tvta5_descripcion);

            imageta5 = (ImageView) itemView.findViewById(R.id.imageta5);

        }
    }
}
