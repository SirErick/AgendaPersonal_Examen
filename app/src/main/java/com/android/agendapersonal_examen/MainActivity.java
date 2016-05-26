package com.android.agendapersonal_examen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText et;
    public static String NAME="NOMBRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= (EditText)findViewById(R.id.editText);
    }
    public void  Agregar(View v){
        Intent i = new Intent(MainActivity.this, AgregarActivity.class);
        startActivity(i);
    }
    public void  Agenda(View v){
        Intent i = new Intent(MainActivity.this, VerActivity.class);
        startActivity(i);
    }
    public void  Buscar(View v){
        String nombre=et.getText().toString();
        Intent i = new Intent(MainActivity.this, BuscarActivity.class);
        i.putExtra(NAME,nombre);
        startActivity(i);
    }
}
