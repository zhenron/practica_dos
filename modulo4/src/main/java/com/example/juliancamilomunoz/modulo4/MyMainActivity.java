package com.example.juliancamilomunoz.modulo4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MyMainActivity extends ActionBarActivity {

    private RadioGroup radioOpGroup;
    private RadioButton radioOpButton;
    private Button btnCalc;
    private EditText editTlado, editTradio, editTbase, editTalt;
    private TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);

        radioOpGroup = (RadioGroup) findViewById(R.id.radioGid);
        btnCalc = (Button) findViewById(R.id.buttonCalcid);
        editTlado = (EditText) findViewById(R.id.editTladoid);
        editTradio = (EditText) findViewById(R.id.editTradioid);
        editTbase = (EditText) findViewById(R.id.editTbaseid);
        editTalt = (EditText) findViewById(R.id.editTaltid);
        textV = (TextView) findViewById(R.id.textVsetresid);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get selected ratio button from RadioGroup
                int selectedId = radioOpGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioOpButton = (RadioButton) findViewById(selectedId);

                double lado = Double.parseDouble(editTlado.getText().toString());
                double radio = Double.parseDouble(editTradio.getText().toString());
                double base = Double.parseDouble(editTbase.getText().toString());
                double alt = Double.parseDouble(editTalt.getText().toString());
                double result = 0;

                switch(radioOpGroup.getCheckedRadioButtonId())
                {
                    case R.id.radioBsquid:
                        result = lado * lado;
                        break;

                    case R.id.radioBcirid:
                        result = 3.1416 * radio * radio;
                        break;

                    case R.id.radioBtriaid:
                        result = base * alt / 2;
                        break;

                    case R.id.radioBrectid:
                        result = base * alt;
                        break;

                    default:
                        result = 0;
                        break;

                }

                textV.setText(Double.toString(result));

            }
        });
    }


}
