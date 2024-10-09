package ch.heigvd.iict.daa.template.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.template.R

private const val ARG_STEP = "param_step"

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
        // création de la vue à partir du xml
        return inflater.inflate(R.layout.fragment_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.let {
            step = it.getInt(ARG_STEP)
        }
        super.onViewCreated(view, savedInstanceState)
        val stepTv = view.findViewById<TextView>(R.id.f_step)
        stepTv.text = "Step $step"

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_STEP, step)
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