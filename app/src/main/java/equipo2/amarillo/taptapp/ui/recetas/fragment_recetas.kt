package equipo2.amarillo.taptapp.ui.recetas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        val v = inflater!!.inflate(R.layout.fragment_recetas_fragment, container, false)
        val titulo = v.findViewById(R.id.titulo) as TextView
        val paso1 = v.findViewById(R.id.paso1) as TextView
        val paso2= v.findViewById(R.id.paso2) as TextView
        val paso3 = v.findViewById(R.id.paso3) as TextView

        if(arguments?.getString("nombre")!=null){
            titulo.text = arguments?.getString("nombre")
            paso1.text = arguments?.getString("paso1")
            paso2.text = arguments?.getString("paso2")
            paso3.text = arguments?.getString("paso3")
        }


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentRecetasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}