package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchSecondActivityButton = findViewById<View>(R.id.launchSecondActivityButton)
        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)
        val radio1 = findViewById<CheckBox>(R.id.radio1)
        val radio2 = findViewById<CheckBox>(R.id.radio2)
        val radio3 = findViewById<CheckBox>(R.id.radio3)
        val checkbox7 = findViewById<CheckBox>(R.id.checkbox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkbox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkbox9)
        val checkbox10 = findViewById<CheckBox>(R.id.checkbox10)
        val checkbox11 = findViewById<CheckBox>(R.id.checkbox11)
        val checkbox12 = findViewById<CheckBox>(R.id.checkbox12)

        launchSecondActivityButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            val dataToSend = ArrayList<String>()

            if(checkbox1.isChecked){
                dataToSend.add("Regular Cut Fries")
            }
            if (checkbox2.isChecked){
                dataToSend.add("Twister Fries")
            }
            if (checkbox3.isChecked){
                dataToSend.add("Crisscross Fries")
            }

            val friesSize = ArrayList<String>()

            if (radio1.isChecked){
                friesSize.add("Small")
            }
            if (radio2.isChecked){
                friesSize.add("Medium")
            }
            if (radio3.isChecked){
                friesSize.add("Large")
            }

            val flavor = ArrayList<String> ()

            if (checkbox7.isChecked){
                flavor.add("Cheese")
            }
            if (checkbox8.isChecked){
                flavor.add("SourCream")
            }
            if (checkbox9.isChecked){
                flavor.add("Barbeque")
            }
            if (checkbox10.isChecked){
                flavor.add("Wasabi")
            }
            if (checkbox11.isChecked){
                flavor.add("SweeetCorn")
            }
            if (checkbox12.isChecked){
                flavor.add("Truffle")
            }
            val itemPrices = mapOf(
                "Regular Cut Fries" to 30.00,  // Price for Regular Cut Fries
                "Twister Fries" to 50.00,      // Price for Twister Fries
                "Crisscross Fries" to 70.00,  // Price for Crisscross Fries
                "Small" to 0.00,             // Price for Small size
                "Medium" to 20.00,            // Price for Medium size
                "Large" to 40.00,             // Price for Large size
                "Cheese" to 5.00,            // Price for Cheese flavor
                "SourCream" to 10.00,         // Price for Sour Cream flavor
                "Barbeque" to 15.00,          // Price for Barbeque flavor
                "Wasabi" to 20.00,            // Price for Wasabi flavor
                "SweeetCorn" to 20.00,        // Price for SweeetCorn flavor
                "Truffle" to 20.00            // Price for Truffle flavor
            )
            var total = 0.00

            for (item in dataToSend + friesSize + flavor) {
                total += itemPrices[item] ?: 0.00
            }


            intent.putExtra("total", total)
            intent.putStringArrayListExtra("key1",dataToSend)
            intent.putStringArrayListExtra("key2",friesSize)
            intent.putStringArrayListExtra("key3", flavor)
            startActivity(intent)
        }
    }
}