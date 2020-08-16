package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }
    public void myButtonListenerMethod(){
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //These code will run when the button will be clicked
                final EditText heightText = (EditText)findViewById(R.id.heightInput);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);

                final EditText weightText = (EditText)findViewById(R.id.weightInput);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);

                double BMI = (weight)/(height * height);

                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_Trimmed = Double.parseDouble(df.format(BMI));

                final EditText BMIResult = (EditText)findViewById(R.id.calBMI);
                BMIResult.setText(Double.toString(BMI_Trimmed));

                String BMI_Cat;
                if(BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if(BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if(BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if(BMI < 25)
                    BMI_Cat = "Normal";
                else if(BMI < 30)
                    BMI_Cat = "Overweight ";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 - Moderately Obese ";
                else if(BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese ";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese ";



                final TextView BMICat = (TextView)findViewById(R.id.BMI_Category);
                BMICat.setText(BMI_Cat);

            }
        });
    }
}