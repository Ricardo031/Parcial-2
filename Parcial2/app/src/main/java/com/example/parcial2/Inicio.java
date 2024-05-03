package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import Adaptadores.Usuarioadaptador;
import Clases.Usuarios;

public class Inicio extends AppCompatActivity {
    RecyclerView rcv_usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        List<Usuarios> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuarios("https://rickandmortyapi.com/api/character/avatar/72.jpeg", "Rick", "Humano", "alive"));
        listaUsuarios.add(new Usuarios("https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Summer", "Humano", "alive"));
        listaUsuarios.add(new Usuarios("https://rickandmortyapi.com/api/character/avatar/190.jpeg", "Vale", "aliens", "alive"));
        listaUsuarios.add(new Usuarios("https://rickandmortyapi.com/api/character/avatar/241.jpeg", "Carls", "aliens", "alive"));

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        Usuarioadaptador adaptador = new Usuarioadaptador(listaUsuarios);
        rcv_usuarios.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new Usuarioadaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Usuarios usuario) {
                Intent intent = new Intent(Inicio.this, Detallecarta.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }
}
