package com.example.juliancamilomunoz.module3;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyMainActivity extends Activity {

    private EditText editTquiz, editTexp, editTlab, editTproy;
    private TextView textV;
    private Button btnCalc;
//    private float quiz, exp, lab, proy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    public void addListenerOnButton() {

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double quiz = Double.parseDouble(editTquiz.getText().toString());
                double exp = Double.parseDouble(editTexp.getText().toString());
                double lab = Double.parseDouble(editTlab.getText().toString());
                double proy = Double.parseDouble(editTproy.getText().toString());
                double result = (quiz*0.15)+(exp*0.1)+(lab*0.4)+(proy*0.35);

                textV.setText(Double.toString(result));

            }
        });
    }


}