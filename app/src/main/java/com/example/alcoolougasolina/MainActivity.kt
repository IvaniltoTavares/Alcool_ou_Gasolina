package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.alcoolougasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{

            if (validarCampos()){
                val precoAlcool = binding.editPrecoAlcool.text.toString().toDouble()
                val precoGasolina = binding.editPrecoGasolina.text.toString().toDouble()
                calcularPreco(precoAlcool,precoGasolina)

            }else{
                Toast.makeText(this,"Preencha os Campos", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun calcularPreco(precoAlcool:Double, precoGasolina:Double){

            var resultado = precoGasolina * 0.7
            if (resultado < precoAlcool) {
                binding.textViewResultado.text = "Gasolina"

            }else{
                binding.textViewResultado.text = "Alcool"
            }
    }


    private fun validarCampos():Boolean{


        if (binding.editPrecoAlcool.text.isEmpty()){
            return false
        }


        if (binding.editPrecoGasolina.text.isEmpty()){
            return false
        }


        return true
    }
}