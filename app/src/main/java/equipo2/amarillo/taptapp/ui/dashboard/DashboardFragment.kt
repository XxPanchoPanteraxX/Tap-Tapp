package equipo2.amarillo.taptapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import equipo2.amarillo.taptapp.R
import equipo2.amarillo.taptapp.databinding.FragmentDashboardBinding
import equipo2.amarillo.taptapp.ui.recetas.fragment_recetas

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val receta1_img = root.findViewById(R.id.receta1_img) as ImageView
        val receta2_img = root.findViewById(R.id.receta2_img) as ImageView
        val receta3_img = root.findViewById(R.id.receta3_img) as ImageView
        val btn_vegetariano = root.findViewById(R.id.vegetariano_btn) as ImageButton
        val btn_vegano = root.findViewById(R.id.vegano_btn) as ImageButton

        receta1_img.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.navigation_dashboard,fragment_recetas())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}