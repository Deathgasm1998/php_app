package curso_intermedio.adapters;

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

import curso_intermedio.temas.Temain_3;

public class AdapIT3 extends RecyclerView.Adapter<AdapIT3.MyViewHolder> {
    Context context;
    ArrayList<Temain_3> tema3s;

    public AdapIT3 (Context c, ArrayList<Temain_3> tm3){
        context = c;
        tema3s = tm3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_inter3,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvti3_titulo.setText(tema3s.get(position).getTitulo3i());
        holder.tvti3_descripcion.setText(tema3s.get(position).getDescripcion3i());

        Glide.with(context)
                .load(tema3s.get(position).getImagen3i())
                .into(holder.imageti3);
    }

    @Override
    public int getItemCount() {
        return tema3s.size();
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvti3_titulo,tvti3_descripcion;
        ImageView imageti3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvti3_titulo = (TextView) itemView.findViewById(R.id.tvti3_titulo);
            tvti3_descripcion = (TextView) itemView.findViewById(R.id.tvti3_descripcion);

            imageti3 = (ImageView) itemView.findViewById(R.id.imageti3);

        }
    }
}
