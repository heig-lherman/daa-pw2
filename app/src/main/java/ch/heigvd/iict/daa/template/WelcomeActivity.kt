package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.iict.daa.template.contract.UsernameInputContract
import ch.heigvd.iict.daa.template.support.LoggableCompatActivity

/**
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

    private val editButtonOnClickListener = registerForActivityResult(UsernameInputContract()) {
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

        editButton.setOnClickListener { editButtonOnClickListener.launch(username) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_KEY_USERNAME, username)
    }

    private fun updateWelcomeLabel() {
        welcomeLabel.text = when (username) {
            null -> getString(R.string.welcome_empty)
            else -> getString(R.string.welcome_with_username, username)
        }
    }
}