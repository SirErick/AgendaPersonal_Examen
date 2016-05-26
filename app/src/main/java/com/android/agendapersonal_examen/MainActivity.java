package com.android.agendapersonal_examen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  Agregar(View v){
        Intent i = new Intent(MainActivity.this, AgregarActivity.class);
        startActivity(i);
    }
    public void  Agenda(View v){
        Intent i = new Intent(MainActivity.this, VerActivity.class);
        startActivity(i);
    }
}
