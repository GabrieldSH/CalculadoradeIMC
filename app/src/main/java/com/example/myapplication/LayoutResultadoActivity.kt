package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class LayoutResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_resultado)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val resultado = intent.getFloatExtra("Extra_resultado",1.1f)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvTabela = findViewById<TextView>(R.id.tvTabela)

        tvResultado.text = resultado.toString()

        /*MENOR QUE 18,5	MAGREZA	0
        ENTRE 18,5 E 24,9	NORMAL	0
        ENTRE 25,0 E 29,9	SOBREPESO	I
        ENTRE 30,0 E 39,9	OBESIDADE	II
        MAIOR QUE 40,0	OBESIDADE GRAVE	III*/

        val classificacao = if (resultado < 18.5f){
            "ABAIXO DA MEDIA"
        } else if (resultado in 18.5f..24.9f){
            "NORMAL"
        } else if (resultado in 25.0f..29.9f){
            "SOBREPESO"
        } else if (resultado in 30.0f..40.0f){
            "OBESIDADE"
        } else{
            "OBESIDADE GRAVE"
        }
        tvTabela.text = getString(R.string.message_classificacao, classificacao)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}