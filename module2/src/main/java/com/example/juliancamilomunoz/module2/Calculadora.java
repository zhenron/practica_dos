package com.example.juliancamilomunoz.module2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Calculadora extends ActionBarActivity {

    private RadioGroup radioOpGroup;
    private RadioButton radioOpButton;
    private Button btnCalc;
    private EditText editTnum1, editTnum2;
    private TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        radioOpGroup = (RadioGroup) findViewById(R.id.radioGid);
        btnCalc = (Button) findViewById(R.id.buttonCalcid);
        editTnum1 = (EditText) findViewById(R.id.editTnum1id);
        editTnum2 = (EditText) findViewById(R.id.editTnum2id);
        textV = (TextView) findViewById(R.id.textVid);
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

                int v1 = Integer.parseInt(editTnum1.getText().toString());
                int v2 = Integer.parseInt(editTnum2.getText().toString());
                int result;

                switch (radioOpGroup.getCheckedRadioButtonId()) {
                    case R.id.radioBsumid:
                        result = v1 + v2;
                        break;

                    case R.id.radioBresid:
                        result = v1 - v2;
                        break;

                    case R.id.radioBmulid:
                        result = v1 * v2;
                        break;

                    case R.id.radioBdivid:
                        result = v1 / v2;
                        break;

                    default:
                        result = 0;
                        break;

                }

                textV.setText(Integer.toString(result));

            }
        });
    }

}