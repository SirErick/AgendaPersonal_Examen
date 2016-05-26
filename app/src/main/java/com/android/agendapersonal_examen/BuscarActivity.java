package com.android.agendapersonal_examen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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

public class BuscarActivity extends AppCompatActivity {


    String nom,nom1;
    TextView tv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        tv1 = (TextView) findViewById(R.id.textView1);

        Intent newint = getIntent();
        nom = newint.getStringExtra(MainActivity.NAME);
        nom1= String.valueOf(nom);
        leerFicheroMemoriaInterna();

    }


    private void leerFicheroMemoriaInterna()
    {
        InputStreamReader flujo=null;
        BufferedReader lector=null;
        try
        {
            flujo= new InputStreamReader(openFileInput("pruebaFichero.txt"));
            lector= new BufferedReader(flujo);
            String texto = lector.readLine();

            while(texto!=null)
            {

                StringTokenizer tokens = new StringTokenizer(texto, ";");

                String codigo = tokens.nextToken();
                String nombre = tokens.nextToken();
                String direc = tokens.nextToken();
                String fecha = tokens.nextToken();
                String correo = tokens.nextToken();

                if (nombre.compareTo(nom1)==0){
                    tv1.setText(codigo+"\n"+nombre+"\n"+direc+"\n"+fecha+"\n"+correo);
                }
                else{
                    Toast.makeText(BuscarActivity.this, nom1, Toast.LENGTH_SHORT).show();

                }


                texto=lector.readLine();




            }

        }
        catch (Exception ex)
        {
            Log.e("erick", "Error al leer fichero desde memoria interna  "+ ex);
        }
        finally
        {
            try {
                if(flujo!=null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
