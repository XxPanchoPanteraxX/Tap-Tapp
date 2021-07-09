package equipo2.amarillo.taptapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TusGustosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tus_gustos)

        val btn_listo = findViewById(R.id.btn_listo) as Button

        btn_listo.setOnClickListener {
            var intent: Intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }



    }
}