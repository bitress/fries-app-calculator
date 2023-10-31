package com.example.explicitintent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val displayText : TextView = findViewById(R.id.displayTxt1)
        val displaySize : TextView = findViewById(R.id.displayTxt2)
        val displayflavor : TextView = findViewById(R.id.displayTxt3)
        val grandtotal : TextView = findViewById(R.id.total)

        val receivedItems = intent.getStringArrayListExtra("key1")
        val receivedSize = intent.getStringArrayListExtra("key2")
        val receivedflavor = intent.getStringArrayListExtra("key3")
        val receivedtotal = intent.getDoubleExtra("total", 0.00)

        grandtotal.text = "Grandtotal: Php $receivedtotal"

        if (receivedItems != null && receivedItems.isNotEmpty()) {
            val itemsText = receivedItems.joinToString(", ")
            displayText.text ="French Fries: $itemsText"
        }
        if (receivedSize != null && receivedSize.isNotEmpty()) {
            val sizeText = receivedSize.joinToString()
            displaySize.text =" Size: $sizeText "
        }
        if (receivedflavor != null && receivedflavor.isNotEmpty()) {
            val flavorText = receivedflavor.joinToString()
            displayflavor.text =" Flavors: $flavorText"
        }

    }
}
