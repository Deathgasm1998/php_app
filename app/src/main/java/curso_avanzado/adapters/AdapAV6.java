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

import curso_avanzado.temas.Temava_6;

public class AdapAV6 extends RecyclerView.Adapter<AdapAV6.MyViewHolder> {
    Context context;
    ArrayList<Temava_6> tema6s;

    public AdapAV6 (Context c, ArrayList<Temava_6> tm6){
        context = c;
        tema6s = tm6;
    }


    @NonNull
    @Override
    public AdapAV6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV6.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava6,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV6.MyViewHolder holder, int position) {

        holder.tvta6_titulo.setText(tema6s.get(position).getTitulo6a());
        holder.tvta6_descripcion.setText(tema6s.get(position).getDescripcion6a());

        Glide.with(context)
                .load(tema6s.get(position).getImagen6a())
                .into(holder.imageta6);
    }

    @Override
    public int getItemCount() {
        return tema6s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta6_titulo,tvta6_descripcion;
        ImageView imageta6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta6_titulo = (TextView) itemView.findViewById(R.id.tvta6_titulo);
            tvta6_descripcion = (TextView) itemView.findViewById(R.id.tvta6_descripcion);

            imageta6 = (ImageView) itemView.findViewById(R.id.imageta6);

        }
    }
}
