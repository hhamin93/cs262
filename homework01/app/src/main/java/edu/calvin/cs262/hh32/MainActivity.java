package edu.calvin.cs262.hh32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.operator_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operator_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner != null){
            spinner.setAdapter(adapter);
        }

    }

    public void calculate(View view) {

        EditText valueA = findViewById(R.id.number_1);
        EditText valueB = findViewById(R.id.number_2);
        String value1_string = valueA.getText().toString();
        String value2_string = valueB.getText().toString();
        int result = 0;
        int value1_int = Integer.parseInt(value1_string);
        int value2_int = Integer.parseInt(value2_string);
//        switch (operator){
//            case "+":
//                result = value1_int + value2_int;
//            case "-":
//                result = value1_int - value2_int;
//            case "/":
//                result = value1_int / value2_int;
//            case "*":
//                result = value1_int * value2_int;
//        }
        if (operator.equals("+")){
            result = value1_int + value2_int;
        } else if (operator.equals("-")){
            result = value1_int - value2_int;
        } else  if (operator.equals("/")){
            result = value1_int / value2_int;
        } else  if (operator.equals("*")){
            result = value1_int * value2_int;
        }
        TextView textView = findViewById(R.id.viewResult);
        String result_string = Integer.toString(result);
        textView.setText(result_string);
//        finish();



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        operator = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
