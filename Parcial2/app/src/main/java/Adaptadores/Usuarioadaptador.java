package Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Clases.Usuarios;

public class Usuarioadaptador extends RecyclerView.Adapter<Usuarioadaptador.ViewHolder> {

    private List<Usuarios> datos;

    public Usuarioadaptador(List<Usuarios> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public Usuarioadaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuarios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Usuarioadaptador.ViewHolder holder, int position) {
        Usuarios dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_usuario, txt_curso_usuario, txt_vivo;
        ImageView img_usuario;

        Button btn2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_curso_usuario = itemView.findViewById(R.id.txt_curso_usuario);
            txt_vivo = itemView.findViewById(R.id.txt_vivo);
            img_usuario = itemView.findViewById(R.id.img_usuario);
            btn2 = itemView.findViewById(R.id.btn2);

        }

        public  void bind(Usuarios dato){
            txt_nombre_usuario.setText(dato.getNombre());
            txt_curso_usuario.setText(dato.getEspecie());
            txt_vivo.setText(dato.getVivos());

            //libreria
            Picasso.get().load(dato.getImagen()).into(img_usuario);
        }
    }



}

