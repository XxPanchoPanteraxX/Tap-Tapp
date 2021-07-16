package equipo2.amarillo.taptapp.ui.explora

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import equipo2.amarillo.taptapp.R

class explora : Fragment() {

    companion object {
        fun newInstance() = explora()
    }

    private lateinit var viewModel: ExploraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.explora_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExploraViewModel::class.java)
        // TODO: Use the ViewModel
    }

}