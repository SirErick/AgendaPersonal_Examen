package com.android.agendapersonal_examen;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    Button btEscribir,btLeer,btLeerRaw;
    EditText et1,et2,et3,et4,et5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);


        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        et4=(EditText) findViewById(R.id.et4);
        et5=(EditText) findViewById(R.id.et5);


        btEscribir=(Button) findViewById(R.id.botonlisto);
        btEscribir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                escribirFicheroMemoriaInterna();
            }
        });




    }
    private void escribirFicheroMemoriaInterna()
    {
        OutputStreamWriter escritor=null;
        try
        {
            escritor=new OutputStreamWriter(openFileOutput("pruebaFichero.txt", Context.MODE_APPEND));
            String telefono= et1.getText().toString();
            String nombre= et2.getText().toString();
            String direccion= et3.getText().toString();
            String fecha= et4.getText().toString();
            String correo= et5.getText().toString();
            escritor.write(telefono+";"+nombre+";"+direccion+";"+fecha+";"+correo+"\n");
            Toast.makeText(AgregarActivity.this, "Registrado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(AgregarActivity.this, MainActivity.class);
            startActivity(i);
        }
        catch (Exception ex)
        {
            Log.e("erick", "Error al escribir fichero a memoria interna");
        }
        finally
        {
            try {
                if(escritor!=null)
                    escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
