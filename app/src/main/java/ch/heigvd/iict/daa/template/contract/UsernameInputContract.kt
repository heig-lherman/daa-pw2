package ch.heigvd.iict.daa.template.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.iict.daa.template.InputNameActivity

/**
 * Contract to get a username from the user.
 * The input is a nullable string representing the active value.
 * The output is a nullable string, null if the user cancelled the action.
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class UsernameInputContract : ActivityResultContract<String?, String?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        val intent = Intent(context, InputNameActivity::class.java)
        intent.putExtra(InputNameActivity.USERNAME_KEY, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }

        return intent?.getStringExtra(InputNameActivity.USERNAME_KEY)
    }
}