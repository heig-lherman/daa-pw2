package ch.heigvd.iict.daa.template.support

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Support activity that logs the lifecycle of the activity
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
abstract class LoggableCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("[STATE CHANGE]", "onCreate %s".format(localClassName))
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d("[STATE CHANGE]", "onStart %s".format(localClassName))
        super.onStart()
    }

    override fun onResume() {
        Log.d("[STATE CHANGE]", "onResume %s".format(localClassName))
        super.onResume()
    }

    override fun onPause() {
        Log.d("[STATE CHANGE]", "onPause %s".format(localClassName))
        super.onPause()
    }

    override fun onStop() {
        Log.d("[STATE CHANGE]", "onStop %s".format(localClassName))
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("[STATE CHANGE]", "onDestroy %s".format(localClassName))
        super.onDestroy()
    }
}