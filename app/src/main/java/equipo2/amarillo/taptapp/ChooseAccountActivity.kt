package equipo2.amarillo.taptapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_account)

        val login_google = findViewById(R.id.login_google) as Button
        val login_fb = findViewById(R.id.login_fb) as Button

        login_google.setOnClickListener {
            var intent: Intent = Intent(this, TusGustosActivity::class.java)
            this.startActivity(intent)
        }

        login_fb.setOnClickListener {
            var intent: Intent = Intent(this, TusGustosActivity::class.java)
            this.startActivity(intent)
        }
    }
}