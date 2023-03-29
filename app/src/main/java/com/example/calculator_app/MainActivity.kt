package com.example.calculator_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculator_app.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnManager()
    }

    private fun addToInput(buttonValue: String): String {
        return "${binding.tvInput.text}$buttonValue"
    }

    private fun getInputExpression() : String {
        var expression = binding.tvInput.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("x"), "*")
        return  expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                binding.tvOutput.text = "Error"
            }else {
                binding.tvOutput.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e : java.lang.Exception) {
            binding.tvOutput.text = "Error"
        }
    }
    private fun btnManager() {
        binding.btnClear.setOnClickListener {
            binding.tvOutput.text = "0"
            binding.tvInput.text = " "
        }

        binding.btnEqual.setOnClickListener {
            showResult()
        }

        binding.btnDot.setOnClickListener {
            binding.tvInput.text = addToInput(".")
        }

        binding.btnPlus.setOnClickListener {
            binding.tvInput.text = addToInput("+")
        }

        binding.btnMin.setOnClickListener {
            binding.tvInput.text = addToInput("-")
        }

        binding.btnTimes.setOnClickListener {
            binding.tvInput.text = addToInput("x")
        }

        binding.btnDivide.setOnClickListener {
            binding.tvInput.text = addToInput("/")
        }

        binding.btnBackspace.setOnClickListener {
            val length = binding.tvInput.length()
            if (length>0){
                binding.tvInput.text = binding.tvInput.text.subSequence(0, length-1)
            }
        }

        binding.btn0.setOnClickListener {
            binding.tvInput.text = addToInput("0")
        }

        binding.btn1.setOnClickListener {
            binding.tvInput.text = addToInput("1")
        }

        binding.btn2.setOnClickListener {
            binding.tvInput.text = addToInput("2")
        }

        binding.btn3.setOnClickListener {
            binding.tvInput.text = addToInput("3")
        }

        binding.btn4.setOnClickListener {
            binding.tvInput.text = addToInput("4")
        }

        binding.btn5.setOnClickListener {
            binding.tvInput.text = addToInput("5")
        }

        binding.btn6.setOnClickListener {
            binding.tvInput.text = addToInput("6")
        }

        binding.btn7.setOnClickListener {
            binding.tvInput.text = addToInput("7")
        }

        binding.btn8.setOnClickListener {
            binding.tvInput.text = addToInput("8")
        }

        binding.btn9.setOnClickListener {
            binding.tvInput.text = addToInput("9")
        }

    }
}