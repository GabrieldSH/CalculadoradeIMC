package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao: Button = findViewById(R.id.botao)
        val edtPeso: EditText = findViewById(R.id.edt_Peso)
        val edtAltura: EditText = findViewById(R.id.edt_Altura)

        botao.setOnClickListener {

            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val resultado: Float = peso / alturaFinal

                val intent = Intent(this, LayoutResultadoActivity::class.java)
                    .apply {
                        putExtra("Extra_resultado", resultado)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}