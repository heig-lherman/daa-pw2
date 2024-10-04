package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for part 2 of the assignment, which is linked to a layout hosting
 * two fragment container views.
 *
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class MainActivityFragment1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment1)
    }
}