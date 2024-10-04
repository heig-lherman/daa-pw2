package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.iict.daa.template.contract.UsernameInputContract
import ch.heigvd.iict.daa.template.support.LoggableCompatActivity

/**
 * Activity for part 1 of the assignment, which handles the logic for the welcome screen.
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class WelcomeActivity : LoggableCompatActivity() {

    private lateinit var welcomeLabel: TextView
    private lateinit var editButton: Button

    private var username: String? = null

    companion object {
        const val STATE_KEY_USERNAME = "@welcome/username"
    }

    private val editActivityIntent = registerForActivityResult(UsernameInputContract()) {
        username = it
        updateWelcomeLabel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        welcomeLabel = findViewById(R.id.welcome_label)
        editButton = findViewById(R.id.edit_button)

        username = savedInstanceState?.getString(STATE_KEY_USERNAME)
        updateWelcomeLabel()

        editButton.setOnClickListener { editActivityIntent.launch(username) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_KEY_USERNAME, username)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        username = savedInstanceState.getString(STATE_KEY_USERNAME)
        updateWelcomeLabel()
    }

    private fun updateWelcomeLabel() {
        welcomeLabel.text = when (username) {
            null -> getString(R.string.welcome_empty)
            else -> getString(R.string.welcome_with_username, username)
        }
    }
}