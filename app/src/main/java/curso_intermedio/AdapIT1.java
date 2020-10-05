package curso_intermedio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curso_php.R;

import java.util.ArrayList;

import curso_basico.AdapT1;
import curso_basico.Tema_1;

public class AdapIT1 extends RecyclerView.Adapter<AdapIT1.MyViewHolder> {
    Context context;
    ArrayList<Temain_1> tema1s;

    public AdapIT1 (Context c, ArrayList<Temain_1> tm1){
        context = c;
        tema1s = tm1;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.inter_tema1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapIT1.MyViewHolder holder, int position) {

        holder.tvt1_titulo.setText(tema1s.get(position).getTitulo());
        holder.tvt1_descripcion.setText(tema1s.get(position).getDescripcion());

        Glide.with(context)
                .load(tema1s.get(position).getImagen())
                .into(holder.imaget1);
    }

    @Override
    public int getItemCount() {
        return tema1s.size();
    }

    /////////////////////////////////
    class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvt1_titulo,tvt1_descripcion;
        ImageView imaget1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvt1_titulo = (TextView) itemView.findViewById(R.id.tvt1_titulo);
            tvt1_descripcion = (TextView) itemView.findViewById(R.id.tvt1_descripcion);

            imaget1 = (ImageView) itemView.findViewById(R.id.imaget1);

        }
    }
}


