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

import curso_avanzado.temas.Temava_4;

public class AdapAV4 extends RecyclerView.Adapter<AdapAV4.MyViewHolder> {
    Context context;
    ArrayList<Temava_4> tema4s;

    public AdapAV4 (Context c, ArrayList<Temava_4> tm4){
        context = c;
        tema4s = tm4;
    }


    @NonNull
    @Override
    public AdapAV4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapAV4.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_ava4,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapAV4.MyViewHolder holder, int position) {

        holder.tvta4_titulo.setText(tema4s.get(position).getTitulo4a());
        holder.tvta4_descripcion.setText(tema4s.get(position).getDescripcion4a());

        Glide.with(context)
                .load(tema4s.get(position).getImagen4a())
                .into(holder.imageta4);
    }

    @Override
    public int getItemCount() {
        return tema4s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvta4_titulo,tvta4_descripcion;
        ImageView imageta4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvta4_titulo = (TextView) itemView.findViewById(R.id.tvta4_titulo);
            tvta4_descripcion = (TextView) itemView.findViewById(R.id.tvta4_descripcion);

            imageta4 = (ImageView) itemView.findViewById(R.id.imageta4);

        }
    }
}
