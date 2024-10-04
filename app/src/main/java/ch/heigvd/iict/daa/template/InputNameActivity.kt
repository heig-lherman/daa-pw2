package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ch.heigvd.iict.daa.template.support.LoggableCompatActivity

/**
 * Activity for part 1 of the assignment, which handles the input logic for the username
 * to mention on the welcome screen. It is called through a contract from the [WelcomeActivity].
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class InputNameActivity : LoggableCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var saveButton: Button

    companion object {
        const val USERNAME_KEY = "@inputName/username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_name)

        usernameInput = findViewById(R.id.username_input)
        saveButton = findViewById(R.id.save_button)

        usernameInput.setText(intent.getStringExtra(USERNAME_KEY))
        saveButton.setOnClickListener { closeActivity() }
    }

    /**
     * Close the activity and return the username to the previous activity
     */
    private fun closeActivity() {
        val data = Intent()
        data.putExtra(USERNAME_KEY, getUsername())
        setResult(RESULT_OK, data)
        finish()
    }

    private fun getUsername(): String {
        return usernameInput.text.toString().trim()
    }
}