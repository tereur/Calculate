package com.example.calculatricebdt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);

        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new view.OnClickListener(){
            @Override
            public void onclick(View v){
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton= findViewById(radioId);
                textView.setText("Your choise: " + radioButton.getText());
            }

        });
    }

    oublic void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton= findViewById(radioId);
        Toast.makeText( context: this, "selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}