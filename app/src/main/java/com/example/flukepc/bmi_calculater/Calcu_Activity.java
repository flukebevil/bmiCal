package com.example.flukepc.bmi_calculater;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calcu_Activity extends AppCompatActivity {
    EditText edt_tall, edt_weight ;
    Button submid, clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
        submid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Calcu_Activity.this, Detail_Activity.class);
                int level=  bikeType(Integer.parseInt(edt_tall.getText().toString()));

                i.putExtra("level_type",getCompareAtLevel(level)+"");
                i.putExtra("bmi", numBmi()+"");
                i.putExtra("bmi_type",calBmi());
                i.putExtra("level",level+"");

                startActivity(i);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_tall.setText("");
                edt_weight.setText("");
            }
        });


    }



    private void setUp(){
        edt_tall = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        submid= findViewById(R.id.btn_koddi);
        clear = findViewById(R.id.btn_clear);



    }

    private Double numBmi(){
        int namnak = Integer.parseInt(edt_weight.getText().toString());
        int tall = Integer.parseInt(edt_tall.getText().toString());
        Double tall_mte = tall / 100.0 ;
        return namnak / Math.pow(tall_mte , 2);
    }

    private String calBmi(){
        int namnak = Integer.parseInt(edt_weight.getText().toString());
        int tall = Integer.parseInt(edt_tall.getText().toString());
        Double tall_mte = tall / 100.0 ;
        Double bmi_check = namnak / Math.pow(tall_mte , 2);

        if (bmi_check < 17.0){
            return "ผอม";
        }else if (bmi_check> 17.0 && bmi_check<18.4){
            return "สมส่วน";
        }else if (bmi_check > 18.5 && bmi_check < 24.9){
            return "ท้วม";
        }else if (bmi_check > 35.0 &&bmi_check<29.9){
            return "อ้วน";
        }else if (bmi_check>30){
            return "น้ำหนักเกิน และ มีความเสี่ยง";
        }
        return "ไม่สามารถประเมิณค่าได้";
    }

    private int bikeType(int tall){

        int level = 0 ;

        if (tall < 152){
           return level;
        }else if(tall > 152 && tall<=169) {
            if (numBmi()>=17.0 && numBmi()<=18.4){
                return level+1;
            }else{
                return level+2;
            }
        }else if(tall >= 170 && tall<=176) {Log.e("tall" , numBmi()+"");
            if (numBmi()>=17.0 && numBmi()<=18.4){
                return level+2;
            }else{
                return level+3;
            }
        }
        else if(tall >= 177 && tall<=181) {
            if (numBmi()>=17.0 && numBmi()<=18.4){
                return level+3;
            }else{
                return level+4;
            }
        }else if(tall >= 182 && tall<=194) {
            if (numBmi()>=17.0 && numBmi()<=18.4){
                return level+4;
            }else{
                return level+5;
            }
        }else if(tall >= 195 && tall<=220) {
            if (numBmi()>=17.0 && numBmi()<=18.4){
                return level+5;
            }else{
                return level+6;
            }
        }


        return level;
    }


    private String getCompareAtLevel(int level){
        if (level == 0 ){
            return "ไม่มี Size ที่เหมาะสมต้องใช้ size สำหรับเด็ก";
        }else if (level == 1){
            return "Size ที่เหมาะสมคือ 15 inches - 16 inches";
        }else if (level == 2){
            return "Size ที่เหมาะสมคือ 16 inches - 17 inches";
        }else if (level == 3){
            return "Size ที่เหมาะสมคือ 18 inches - 19 inches";
        }else if (level == 4){
            return "Size ที่เหมาะสมคือ 20 inches - 21 inches";
        }else if (level == 5){
            return "Size ที่เหมาะสมคือ 21 inches - 22 inches";
        }else if (level == 6){
            return "Size ที่เหมาะสมคือ 21 inches - 22 inches. You need to loose weight immediately";
        }else
        {
            return "";
        }

    }


}
