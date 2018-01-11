package com.example.guillers.cursoandroid2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv_result;
    private Button operate;
    private RadioButton sum,res,mul,div;
    private RadioGroup choice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.Number_1);
        et2 = findViewById(R.id.Number_2);
        tv_result = findViewById(R.id.result);
        operate  = findViewById(R.id.calculate);
        sum= findViewById(R.id.rb1);
        res = findViewById(R.id.rb2);
        mul = findViewById(R.id.rb3);
        div = findViewById(R.id.rb4);
        choice = findViewById(R.id.choice);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operar();
            }
        };
        operate.setOnClickListener(cl);
    }


    public void operar(){
        Integer uno= Integer.parseInt(et1.getText().toString());
        Integer dos = Integer.parseInt(et2.getText().toString());

        if(sum.isChecked()){
            tv_result.setText(String.valueOf(uno+dos));
        }else if(res.isChecked()){
            tv_result.setText(String.valueOf(uno-dos));
        }else if (mul.isChecked()){
            tv_result.setText(String.valueOf(uno*dos));
        }else {
            tv_result.setText(String.valueOf(uno/dos));
        }

    }

    private void keyboard(){
        View view = this.getCurrentFocus();
        assert view != null;
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
