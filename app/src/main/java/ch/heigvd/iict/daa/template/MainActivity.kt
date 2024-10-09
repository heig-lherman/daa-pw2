package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Main activity for our application, which handles redirecting the users to the different
 * parts of the assignment.
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class MainActivity : AppCompatActivity() {

    private lateinit var buttonPart1 : Button
    private lateinit var buttonPart2 : Button
    private lateinit var buttonPart3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPart1 = findViewById(R.id.part1_button)
        buttonPart2 = findViewById(R.id.part2_button)
        buttonPart3 = findViewById(R.id.part3_button)

        buttonPart1.setOnClickListener { startActivity(Intent(this@MainActivity, WelcomeActivity::class.java)) }
        buttonPart2.setOnClickListener { startActivity(Intent(this@MainActivity, MainActivityFragment1::class.java)) }
        buttonPart3.setOnClickListener { startActivity(Intent(this@MainActivity, MainActivityFragment2::class.java)) }
    }
}