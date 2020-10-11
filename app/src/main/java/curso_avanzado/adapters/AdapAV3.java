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

import curso_avanzado.temas.Temava_3;

public class AdapAV3 extends RecyclerView.Adapter<AdapAV3.MyViewHolder> {
    Context context;
    ArrayList<Temava_3> tema3s;

    public AdapAV3 (Context c, ArrayList<Temava_3> tm3){
        context = c;
        tema3s = tm3;
    }


    @NonNull
    @Override
    public AdapAV3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV3.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava3,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV3.MyViewHolder holder, int position) {

        holder.tvta3_titulo.setText(tema3s.get(position).getTitulo3a());
        holder.tvta3_descripcion.setText(tema3s.get(position).getDescripcion3a());

        Glide.with(context)
                .load(tema3s.get(position).getImagen3a())
                .into(holder.imageta3);
    }

    @Override
    public int getItemCount() {
        return tema3s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta3_titulo,tvta3_descripcion;
        ImageView imageta3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta3_titulo = (TextView) itemView.findViewById(R.id.tvta3_titulo);
            tvta3_descripcion = (TextView) itemView.findViewById(R.id.tvta3_descripcion);

            imageta3 = (ImageView) itemView.findViewById(R.id.imageta3);

        }
    }
}
