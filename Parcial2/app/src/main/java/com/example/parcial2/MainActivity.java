package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parcial2.Inicio;
import com.example.parcial2.R;

public class MainActivity extends AppCompatActivity {
    private EditText pt1, pt2;
    private Button btn1;

    String dato;
    android.content.SharedPreferences SharedPreferences;
    SharedPreferences.Editor editor;
    public  static final String dataUser = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        pt1 = findViewById(R.id.pt1);
        pt2 = findViewById(R.id.pt2);

        SharedPreferences = getSharedPreferences(dataUser, modo_private);
        editor = SharedPreferences.edit();

        dato = getApplicationContext().getSharedPreferences(dataUser, modo_private).getString("user", " ");

        if (!dato.equalsIgnoreCase(" ")) {
            Intent i = new Intent(MainActivity.this, Inicio.class);
            startActivity(i);
            finish();
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 =pt1.getText().toString();
                String v2 =pt2.getText().toString();
                editor.putString("user", pt1.getText().toString());
                editor.commit();

                if (v1.equals("") && v2.equals("")) {
                    Toast.makeText(MainActivity.this, "Tiene que llenar los campos", Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(MainActivity.this, Inicio.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
}