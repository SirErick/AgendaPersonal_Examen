package com.android.agendapersonal_examen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerActivity extends AppCompatActivity {



    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        tv = (TextView) findViewById(R.id.textView);
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
            String newtexto=null;
            while(texto!=null)
            {
                newtexto=newtexto+texto+"\n";
                texto=lector.readLine();


            }
            tv.setText(newtexto);
        }
        catch (Exception ex)
        {
            Log.e("erick", "Error al leer fichero desde memoria interna");
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
