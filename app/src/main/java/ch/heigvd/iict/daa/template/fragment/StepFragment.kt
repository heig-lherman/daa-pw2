package ch.heigvd.iict.daa.template.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.template.R
import ch.heigvd.iict.daa.template.WelcomeActivity

private const val ARG_STEP = "param_step"

/**
 * @author Emilie Bressoud
 * @author Loïc Herman
 * @author Sacha Butty
 */
class StepFragment : Fragment() {

    private var step: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            step = it.getInt(ARG_STEP)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create the view from the XML
        return inflater.inflate(R.layout.fragment_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stepTv = view.findViewById<TextView>(R.id.f_step)
        stepTv.text = getString(R.string.step_label, step)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_STEP, step)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            step = savedInstanceState.getInt(ARG_STEP)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(step: Int = 0) =
            StepFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STEP, step)
                }
            }
    }

}