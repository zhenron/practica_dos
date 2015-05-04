package com.example.juliancamilomunoz.module3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MyMainActivity extends Activity {

    private EditText editTquiz, editTexp, editTlab, editTproy;
    private TextView textV;
    private Button btnCalc;
    private double result;
//    private float quiz, exp, lab, proy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Toast.makeText(this, getResources().getString(R.string.TOnCreate), Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);

        editTquiz = (EditText) findViewById(R.id.editTquizid);
        editTexp = (EditText) findViewById(R.id.editTexpid);
        editTlab = (EditText) findViewById(R.id.editTlabid);
        editTproy = (EditText) findViewById(R.id.editTproyid);
        textV = (TextView) findViewById(R.id.textVsetresultid);
        btnCalc = (Button) findViewById(R.id.buttonCalcid);
        addListenerOnButton();
    }

/*    public void AbrirAcercaDe(View view) {
        Intent i = new Intent(this, Abouut.class);
        startActivity(i);
    }*/

    public void addListenerOnButton() {

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double quiz = Double.parseDouble(editTquiz.getText().toString());
                double exp = Double.parseDouble(editTexp.getText().toString());
                double lab = Double.parseDouble(editTlab.getText().toString());
                double proy = Double.parseDouble(editTproy.getText().toString());
                result = (quiz * 0.15) + (exp * 0.1) + (lab * 0.4) + (proy * 0.35);

                //textV.setText(String.format("%.2f", Double.toString(result)));
                textV.setText(String.format("%.2f", result));

            }
        });
    }
/*
    @Override
    protected void onStart() {
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, Porcentajes.class);
            i.putExtra("pQuiz",15); //10 40 35
            i.putExtra("pExp",10);
            i.putExtra("pPra",40);
            i.putExtra("pPro",35);
            startActivityForResult(i, 1234);
            return true;
        }

        if (id == R.id.item_about) {
            Intent i = new Intent(this, Abouut.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onSaveInstanceState(Bundle guardarEstado) {
        super.onSaveInstanceState(guardarEstado);
        guardarEstado.putDouble("myresult", result);
    }

    @Override
    protected void onRestoreInstanceState(Bundle recEstado) {
        super.onRestoreInstanceState(recEstado);
        result = recEstado.getDouble("myresult");
        //textV.setText(Double.toString(result));
        textV.setText(String.format("%.2f", result));
    }


}