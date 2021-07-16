package equipo2.amarillo.taptapp.ui.dashboard

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
        val db=Firebase.firestore

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
            val recetaPizza = db.collection("recetas")
            val query = recetaPizza.whereEqualTo("nombre","Pizza")
            var pizza = query.get().addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }

            var result = pizza.result
            var lista=result?.documents
            var receta=lista?.get(0)

            var bundle:Bundle = Bundle()
            bundle.putString("nombre",receta?.get("nombre").toString())
            bundle.putString("paso1",receta?.get("Paso1").toString())
            bundle.putString("paso2",receta?.get("Paso2").toString())
            bundle.putString("paso3",receta?.get("Paso3").toString())
            bundle.putBoolean("huevos",receta?.get("huevos") as Boolean)
            bundle.putBoolean("vegetariano",receta?.get("vegetariano") as Boolean)
            bundle.putBoolean("verduras",receta?.get("verduras") as Boolean)


            val fragmentoReceta = fragment_recetas()

            fragmentoReceta.arguments = bundle


            transaction?.replace(R.id.navigation_dashboard,fragment_recetas())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        receta2_img.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val recetaBrocheta = db.collection("recetas")
            val query = recetaBrocheta.whereEqualTo("nombre","Brocheta")
            var pizza = query.get().addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }

            var result = pizza.result
            var lista=result?.documents
            var receta=lista?.get(0)

            var bundle:Bundle = Bundle()
            bundle.putString("nombre",receta?.get("nombre").toString())
            bundle.putString("paso1",receta?.get("Paso1").toString())
            bundle.putString("paso2",receta?.get("Paso2").toString())
            bundle.putString("paso3",receta?.get("Paso3").toString())
            bundle.putBoolean("carne",receta?.get("carne") as Boolean)
            bundle.putBoolean("pollo",receta?.get("pollo") as Boolean)


            val fragmentoReceta = fragment_recetas()

            fragmentoReceta.arguments = bundle


            transaction?.replace(R.id.navigation_dashboard,fragment_recetas())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        receta3_img.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val recetaBrocheta = db.collection("recetas")
            val query = recetaBrocheta.whereEqualTo("nombre","Pastel")
            var pizza = query.get().addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }

            var result = pizza.result
            var lista=result?.documents
            var receta=lista?.get(0)

            var bundle:Bundle = Bundle()
            bundle.putString("nombre",receta?.get("nombre").toString())
            bundle.putString("paso1",receta?.get("Paso1").toString())
            bundle.putString("paso2",receta?.get("Paso2").toString())
            bundle.putString("paso3",receta?.get("Paso3").toString())
            bundle.putBoolean("huevos",receta?.get("huevo") as Boolean)
            bundle.putBoolean("verduras",receta?.get("pollo") as Boolean)


            val fragmentoReceta = fragment_recetas()

            fragmentoReceta.arguments = bundle


            transaction?.replace(R.id.navigation_dashboard,fragment_recetas())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        btn_vegetariano.setOnClickListener {

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}