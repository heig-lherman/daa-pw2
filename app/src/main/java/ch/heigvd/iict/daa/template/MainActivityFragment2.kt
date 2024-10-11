package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.template.fragment.StepFragment

/**
 * Activity for part 3 of the assignment, FragmentManager
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class MainActivityFragment2 : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var closeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment2)


        nextButton = findViewById(R.id.next_button)
        backButton = findViewById(R.id.back_button)
        closeButton = findViewById(R.id.close_button)

        nextButton.setOnClickListener { forward() }
        backButton.setOnClickListener { back() }
        closeButton.setOnClickListener { close() }

        // Add the first fragment
        nextStep()

    }

    private fun back() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            finish()
    }

    private fun forward() {
        nextStep()
    }

    private fun close() {
        finish()
    }

    private fun nextStep() {
        val currentStep = supportFragmentManager.backStackEntryCount
        // Create a new fragment and add it to the activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view_step, StepFragment.newInstance(currentStep))
            .addToBackStack(null)
            .commit()
    }
}