package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.Usuarioadaptador;
import Clases.Usuarios;

public class Inicio extends AppCompatActivity {
    RecyclerView rcv_usuarios;

    Button btn2;
    List<Usuarios> listaUsuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);


        Usuarios usu1 = new Usuarios("https://rickandmortyapi.com/api/character/avatar/72.jpeg", "Rick", "Humano", "alive");
        Usuarios usu2 = new Usuarios("https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Summer", "Humano", "alive");
        Usuarios usu3 = new Usuarios("https://rickandmortyapi.com/api/character/avatar/190.jpeg", "Vale", "aliens", "alive");
        Usuarios usu4 = new Usuarios("https://rickandmortyapi.com/api/character/avatar/241.jpeg", "Carls", "aliens", "alive");

        listaUsuarios.add(usu1);
        listaUsuarios.add(usu2);
        listaUsuarios.add(usu3);
        listaUsuarios.add(usu4);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new Usuarioadaptador(listaUsuarios));

        rcv_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, Detallecarta.class);
                startActivity(intent);
            }
        });
    }

}