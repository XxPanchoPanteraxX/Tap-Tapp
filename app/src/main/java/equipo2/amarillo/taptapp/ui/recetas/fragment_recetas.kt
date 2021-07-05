package equipo2.amarillo.taptapp.ui.recetas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import equipo2.amarillo.taptapp.R

class fragment_recetas : Fragment() {

    companion object {
        fun newInstance() = fragment_recetas()
    }

    private lateinit var viewModel: FragmentRecetasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recetas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentRecetasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}