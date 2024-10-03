package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_relative)

        val btn = findViewById<Button>(R.id.connect)
        btn.setOnClickListener { // Displaying simple Toast message
            Toast.makeText(applicationContext, "This a toast message", Toast.LENGTH_LONG).show()
        }
    }
}