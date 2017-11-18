package com.example.flukepc.bmi_calculater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail_Activity extends AppCompatActivity {
Bundle extra;
String bmi,bmi_type,level, level_type;
TextView et_bmi , et_bmiType, et_level , et_levelType;
Button back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        setUp();
        setResult();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail_Activity.this , Calcu_Activity.class));
            }
        });

    }

    private void setUp(){
        extra= getIntent().getExtras();
        bmi  = extra.getString("bmi_type");
        bmi_type  = extra.getString("bmi");
        level = extra.getString("level");
        level_type  = extra.getString("level_type");


        et_bmi = findViewById(R.id.tv_bmi);
        et_bmiType = findViewById(R.id.tv_find_bmi);
        et_level = findViewById(R.id.tv_lv);
        et_levelType = findViewById(R.id.tv_bicycle);
        back = findViewById(R.id.back);

    }
    private void setResult(){
        et_bmi.setText(bmi);
        et_bmiType.setText(bmi_type);
        et_level.setText(level);;
        et_levelType.setText(level_type);
    }


}
