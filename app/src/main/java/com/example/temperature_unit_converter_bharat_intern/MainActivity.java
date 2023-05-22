package com.example.temperature_unit_converter_bharat_intern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText tempET;
    Button convertBtn,resetBtn;
    RadioButton c2f,f2c,c2k,k2c;
    TextView errorTV;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempET = (EditText) findViewById(R.id.temperatureValue);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        c2f = (RadioButton) findViewById(R.id.cTofRadio); // Celsius to fahrenheit radio
        f2c = (RadioButton) findViewById(R.id.fTocRadio); // Fahrenheit to celsius radio
        c2k = (RadioButton) findViewById(R.id.cTokRadio); // Celsius to kelvin radio
        k2c = (RadioButton) findViewById(R.id.kTocRadio); // Kelvin to celsius radio
        radioGroup  = (RadioGroup) findViewById(R.id.radioGroup);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    errorTV.setText("Please select atleast one conversion method.");
                }
                else
                {
                    if(tempET.getText().toString().equals("") || tempET.getText().toString().equals(null) ){
                        errorTV.setText("Please enter a value in the text box.");
                    }else {
                        // Celsius to fahrenheit radio button is clicked
                        if (c2f.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double celsiusValue = Double.parseDouble(value);

                            Double convertedValue = (celsiusValue * 9 / 5) + 32;

                            tempET.setText(convertedValue.toString());
                        }

                        // Fahrenheit to celsius radio button is clicked
                        else if (f2c.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double fahrenheitValue = Double.parseDouble(value);
                            Double convertedValue = (fahrenheitValue - 32) * 5 / 9;
                            tempET.setText(convertedValue.toString());
                        }

                        // Celsius to kelvin button is checked
                        else if (c2k.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double celsiusValue = Double.parseDouble(value);
                            Double convertedValue = celsiusValue + 273.15;
                            tempET.setText(convertedValue.toString());
                        }

                        // Kelvin to celsius button is checked
                        else if (k2c.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double kelvinValue = Double.parseDouble(value);
                            Double convertedValue = kelvinValue - 273.15;
                            tempET.setText(convertedValue.toString());
                        }
                    }
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                errorTV.setText(null);
                tempET.setText(null);
            }
        });
    }
}