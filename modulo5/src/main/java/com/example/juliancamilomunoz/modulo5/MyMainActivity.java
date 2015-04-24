package com.example.juliancamilomunoz.modulo5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MyMainActivity extends ActionBarActivity {
    private Spinner myspinner;
    private List<String> mylist;
    private RadioGroup radioOpGroup;
    private RadioButton radioOpButton;
    private Button btnCargar, btnChangeDate;;
    private EditText editTname, editTemail, editTtel;
    private TextView textVname, textVemail, textVtel, textVsexo, textVcity, textVdate;;
    private String Ciudad;
    private DatePicker mydatepicker;
    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);

        radioOpGroup = (RadioGroup) findViewById(R.id.radioGid);
        btnCargar = (Button) findViewById(R.id.butCargid);
        editTname = (EditText) findViewById(R.id.editTnameid);
        editTemail = (EditText) findViewById(R.id.editTemailid);
        editTtel = (EditText) findViewById(R.id.editTtelid);
        textVname = (TextView) findViewById(R.id.textVnameid);
        textVemail = (TextView) findViewById(R.id.textVemailid);
        textVtel = (TextView) findViewById(R.id.textVtelid);
        textVsexo = (TextView) findViewById(R.id.textVsexoid);
        textVcity = (TextView) findViewById(R.id.textVcityid);

        setCurrentDateOnView();
        addListenerOnButton();
        DatosPorDefecto();
        addOnItemSelectedListener();
    }

    private void DatosPorDefecto(){
        myspinner = (Spinner) findViewById(R.id.spid);
        mylist = new ArrayList<String>();
        myspinner = (Spinner) this.findViewById(R.id.spid);
        mylist.add("Medellin");
        mylist.add("Cali");
        mylist.add("Barranquilla");
        mylist.add("Bogotá");
        mylist.add("Bucaramanga");
        mylist.add("Pasto");
        mylist.add("San Andrés");
        mylist.add("Guajira");
        ArrayAdapter<String> adaptator = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mylist);
        adaptator.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adaptator);
    }

    public void addOnItemSelectedListener() {
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(arg0.getContext(), "Seleccionado: " + arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
                Ciudad = arg0.getItemAtPosition(arg2).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void addListenerOnButton() {

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);


                 //get selected ratio button from RadioGroup
                int selectedId = radioOpGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioOpButton = (RadioButton) findViewById(selectedId);

                textVname.setText(editTname.getText().toString());
                textVemail.setText(editTemail.getText().toString());
                textVtel.setText(editTtel.getText().toString());
                textVsexo.setText(radioOpButton.getText().toString());
                textVcity.setText(Ciudad);
            }
        });
    }

    public void addListenerOnButtonDate() {

        btnChangeDate = (Button) findViewById(R.id.btnChangeDateid);

        btnChangeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);

            }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            textVdate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            // set selected date into datepicker also
            mydatepicker.init(year, month, day, null);

        }
    };

    // display current date
    public void setCurrentDateOnView() {

        textVdate = (TextView) findViewById(R.id.textVdateid);
        mydatepicker = (DatePicker) findViewById(R.id.dpid);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        textVdate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

        // set current date into datepicker
        mydatepicker.init(year, month, day, null);

    }
}
