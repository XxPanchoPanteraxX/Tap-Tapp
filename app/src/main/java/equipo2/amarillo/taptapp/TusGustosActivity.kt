package equipo2.amarillo.taptapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import equipo2.amarillo.taptapp.ui.dashboard.DashboardFragment

class TusGustosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tus_gustos)

        val btn_listo = findViewById(R.id.btn_listo) as Button

        btn_listo.setOnClickListener {
            var intent: Intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        val img_carne = findViewById(R.id.img_carne) as ImageView
        val img_frutas = findViewById(R.id.img_frutas) as ImageView
        val img_vegetales = findViewById(R.id.img_vegetales) as ImageView
        val img_especias = findViewById(R.id.img_especias) as ImageView
        val img_huevos = findViewById(R.id.img_huevos) as ImageView
        val img_picante = findViewById(R.id.img_picante) as ImageView

        img_carne.setOnClickListener {
            if(img_carne.background==null) {
                img_carne.setBackgroundResource(R.drawable.gradient)
            }else{
                img_carne.setBackgroundResource(R.drawable.transparente)
            }
        }

        img_frutas.setOnClickListener {
            if(img_frutas.background==null) {
                img_frutas.setBackgroundResource(R.drawable.gradient)
            }else{
                img_frutas.setBackgroundResource(R.drawable.transparente)
            }
        }

        img_vegetales.setOnClickListener {
            if(img_vegetales.background==null) {
                img_vegetales.setBackgroundResource(R.drawable.gradient)
            }else{
                img_vegetales.setBackgroundResource(R.drawable.transparente)
            }
        }

        img_especias.setOnClickListener {
            if(img_especias.background==null) {
                img_especias.setBackgroundResource(R.drawable.gradient)
            }else{
                img_especias.setBackgroundResource(R.drawable.transparente)
            }
        }

        img_huevos.setOnClickListener {
            if(img_huevos.background==null) {
                img_huevos.setBackgroundResource(R.drawable.gradient)
            }else{
                img_huevos.setBackgroundResource(R.drawable.transparente)
            }
        }

        img_picante.setOnClickListener {
            if(img_picante.background==null) {
                img_picante.setBackgroundResource(R.drawable.gradient)
            }else{
                img_picante.setBackgroundResource(R.drawable.transparente)
            }
        }

    }
}