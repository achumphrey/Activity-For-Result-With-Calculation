package com.example.activityforresultwithcalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv_dispay;
    private Button btn_add;
    private Button btn_subtract;
    private int num_1;
    private int num_2;
    public static String RESULT = "add_result";
    private int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_dispay = findViewById(R.id.tv_display);
        btn_add = findViewById(R.id.btn_add);
        btn_subtract = findViewById(R.id.btn_subtract);
        Intent intent = getIntent();

        num_1 = Integer.parseInt(intent.getStringExtra(MainActivity.NUM_1));
        num_2 = Integer.parseInt(intent.getStringExtra(MainActivity.NUM_2));

        tv_dispay.setText("Numbers: " + num_1 + ", " +num_2);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendBackAdd();
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendBackSubtract();
            }
        });
    }

    public void sendBackAdd(){

        Intent intent = new Intent();
        result = num_1 + num_2;
        intent.putExtra(SecondActivity.RESULT, Integer.toString(result));
        setResult(RESULT_OK, intent);
        finish();
    }

    public void sendBackSubtract(){

        Intent intent = new Intent();
        result = num_1 - num_2;
        intent.putExtra(SecondActivity.RESULT, Integer.toString(result));
        setResult(RESULT_OK, intent);
        finish();
    }
}
