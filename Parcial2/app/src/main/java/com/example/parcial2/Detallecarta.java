package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial2.MainActivity;
import com.squareup.picasso.Picasso;

import Clases.Usuarios;

public class Detallecarta extends AppCompatActivity {
    private TextView tvNombreUsuario, tvVivo, tv_Especie;
    private ImageView imgUsuario;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecarta);

        imgUsuario = findViewById(R.id.img_usuario);
        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario);
        tvVivo = findViewById(R.id.tv_vivo);
        tv_Especie = findViewById(R.id.tv_Especie);
        btnCerrarSesion = findViewById(R.id.btn_cerrar_sesion);

        Usuarios usuario = getIntent().getParcelableExtra("usuario");

        if (usuario != null) {
            Picasso.get().load(usuario.getImagen()).into(imgUsuario);
            tvNombreUsuario.setText(usuario.getNombre());
            tvVivo.setText("Vivo: " + usuario.getVivos());
            tv_Especie.setText("Especie: " + usuario.getEspecie());
        }

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences(MainActivity.dataUser, MODE_PRIVATE).edit().clear().apply();

                Intent intent = new Intent(Detallecarta.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}