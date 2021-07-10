package equipo2.amarillo.taptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_register)
    }

    private fun validaRegistro(){
        val et_correo: EditText = findViewById(R.id.email)
        val et_contra1: EditText = findViewById(R.id.contrasenia)
        val et_contra2: EditText = findViewById(R.id.contrasenia_confirm)
        val et_nombre: EditText = findViewById(R.id.nombre)
        val et_apellido: EditText= findViewById(R.id.apellido)

        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var contra2: String = et_contra2.text.toString()
        var nombre: String = et_nombre.text.toString()
        var apellido: String = et_apellido.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() && !contra2.isNullOrBlank()
            && !nombre.isNullOrBlank() && !apellido.isNullOrBlank()){

            if (contra1==contra2){

            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()

            }

        }else{
            Toast.makeText(this, "Ingresar datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(baseContext, "Se ha creado correctamente.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}