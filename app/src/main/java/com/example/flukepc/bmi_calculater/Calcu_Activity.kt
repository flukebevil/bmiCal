package com.example.flukepc.bmi_calculater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.flukepc.bmi_calculater.R.id.btn_koddi

class Calcu_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_koddi {
            val i = Intent(this@Calcu_Activity, Detail_Activity::class.java)
            val level = bikeType(Integer.parseInt(edt_height.text.toString()))

            i.putExtra("level_type", getCompareAtLevel(level) + "")
            i.putExtra("bmi", numBmi().toString() + "")
            i.putExtra("bmi_type", calBmi())
            i.putExtra("level", level.toString() + "")

            startActivity(i)
        }
        btn_clear.setOnClickListener {
            edt_height.setText("")
            edt_weight.setText("")
        }
    }

    private fun numBmi(): Double {
        val namnak = Integer.parseInt(edt_weight.text.toString())
        val tall = Integer.parseInt(edt_height.text.toString())
        val tall_mte = tall / 100.0
        return namnak / Math.pow(tall_mte, 2.0)
    }

    private fun calBmi(): String {
        val namnak = Integer.parseInt(edt_weight.text.toString())
        val tall = Integer.parseInt(edt_height.text.toString())
        val tall_mte = tall / 100.0
        val bmi_check = namnak / Math.pow(tall_mte, 2.0)

        if (bmi_check < 17.0) {
            return "ผอม"
        } else if (bmi_check > 17.0 && bmi_check < 18.4) {
            return "สมส่วน"
        } else if (bmi_check > 18.5 && bmi_check < 24.9) {
            return "ท้วม"
        } else if (bmi_check > 35.0 && bmi_check < 29.9) {
            return "อ้วน"
        } else if (bmi_check > 30) {
            return "น้ำหนักเกิน และ มีความเสี่ยง"
        }
        return "ไม่สามารถประเมิณค่าได้"
    }

    private fun bikeType(tall: Int): Int {

        val level = 0

        if (tall < 152) {
            return level
        } else if (tall > 152 && tall <= 169) {
            return if (numBmi() >= 17.0 && numBmi() <= 18.4) {
                level + 1
            } else {
                level + 2
            }
        } else if (tall >= 170 && tall <= 176) {
            Log.e("tall", numBmi().toString() + "")
            return if (numBmi() >= 17.0 && numBmi() <= 18.4) {
                level + 2
            } else {
                level + 3
            }
        } else if (tall >= 177 && tall <= 181) {
            return if (numBmi() >= 17.0 && numBmi() <= 18.4) {
                level + 3
            } else {
                level + 4
            }
        } else if (tall >= 182 && tall <= 194) {
            return if (numBmi() >= 17.0 && numBmi() <= 18.4) {
                level + 4
            } else {
                level + 5
            }
        } else if (tall >= 195 && tall <= 220) {
            return if (numBmi() >= 17.0 && numBmi() <= 18.4) {
                level + 5
            } else {
                level + 6
            }
        }


        return level
    }

    private fun getCompareAtLevel(level: Int): String {
        return if (level == 0) {
            "ไม่มี Size ที่เหมาะสมต้องใช้ size สำหรับเด็ก"
        } else if (level == 1) {
            "Size ที่เหมาะสมคือ 15 inches - 16 inches"
        } else if (level == 2) {
            "Size ที่เหมาะสมคือ 16 inches - 17 inches"
        } else if (level == 3) {
            "Size ที่เหมาะสมคือ 18 inches - 19 inches"
        } else if (level == 4) {
            "Size ที่เหมาะสมคือ 20 inches - 21 inches"
        } else if (level == 5) {
            "Size ที่เหมาะสมคือ 21 inches - 22 inches"
        } else if (level == 6) {
            "Size ที่เหมาะสมคือ 21 inches - 22 inches. You need to loose weight immediately"
        } else {
            ""
        }
    }
}
