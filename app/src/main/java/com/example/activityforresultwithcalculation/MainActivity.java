package com.example.activityforresultwithcalculation;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_num1;
    private EditText ed_num2;
    private TextView tv_result;
    private Button btn_get_result;
    public static String NUM_1 = "number_1";
    public static String NUM_2 = "number_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_num1 = findViewById(R.id.ed_num1);
        ed_num2 = findViewById(R.id.ed_num2);
        btn_get_result = findViewById(R.id.btn_get_result);
        tv_result = findViewById(R.id.tv_result);

        btn_get_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(NUM_1, ed_num1.getText().toString());
                intent.putExtra(NUM_2, ed_num2.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                tv_result.setText(data.getStringExtra(SecondActivity.RESULT));
            }
            if (resultCode == RESULT_CANCELED) {
                //Handle case
            }
        }
    }
}
