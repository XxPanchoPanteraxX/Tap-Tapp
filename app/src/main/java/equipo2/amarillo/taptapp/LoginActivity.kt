package equipo2.amarillo.taptapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity (){
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = Firebase.auth


        val btn_registrarse: Button = findViewById(R.id.register_btn)
        val btn_contra: TextView = findViewById(R.id.contrasenia)
        val btn_ingresar: Button = findViewById(R.id.login_firebase)

        btn_registrarse.setOnClickListener{
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_ingresar.setOnClickListener{
            valida_ingreso()
        }
    }

    private fun valida_ingreso(){
        val et_usuario: EditText = findViewById(R.id.usuario)
        val et_contra: EditText = findViewById(R.id.contrasenia)

        var usuario: String = et_usuario.text.toString()
        var contra: String = et_contra.text.toString()

        if(!usuario.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(usuario, contra)
        }else{
            Toast.makeText(this, "Ingresar datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ingresaFirebase(usuario: String, contra: String){
        auth.signInWithEmailAndPassword(usuario, contra)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val profilepicture: ImageView = findViewById(R.id.imageView)
                    val name: TextView = findViewById(R.id.nombre)
                    profilepicture.setImageURI(user?.photoUrl)
                    name.setText(user?.displayName)
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }

}