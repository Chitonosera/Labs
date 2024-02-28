package com.example.lab1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder



class CalculatorActivity : AppCompatActivity() {
    private lateinit var expression: TextView
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)

        findViewById<Button>(R.id.btn_one).setOnClickListener { appendOnExpression("1", true) }
        findViewById<Button>(R.id.btn_two).setOnClickListener { appendOnExpression("2", true) }
        findViewById<Button>(R.id.btn_tree).setOnClickListener { appendOnExpression("3", true) }
        findViewById<Button>(R.id.btn_four).setOnClickListener { appendOnExpression("4", true) }
        findViewById<Button>(R.id.btn_five).setOnClickListener { appendOnExpression("5", true) }
        findViewById<Button>(R.id.btn_six).setOnClickListener { appendOnExpression("6", true) }
        findViewById<Button>(R.id.btn_seven).setOnClickListener { appendOnExpression("7", true) }
        findViewById<Button>(R.id.btn_eight).setOnClickListener { appendOnExpression("8", true) }
        findViewById<Button>(R.id.btn_nine).setOnClickListener { appendOnExpression("9", true) }
        findViewById<Button>(R.id.btn_zero).setOnClickListener { appendOnExpression("0", true) }
        findViewById<Button>(R.id.btn_dot).setOnClickListener { appendOnExpression(".", true) }

        findViewById<Button>(R.id.btn_plus).setOnClickListener { appendOnExpression("+", false) }
        findViewById<Button>(R.id.btn_minus).setOnClickListener { appendOnExpression("-", false) }
        findViewById<Button>(R.id.btn_multi).setOnClickListener { appendOnExpression("*", false) }
        findViewById<Button>(R.id.btn_div).setOnClickListener { appendOnExpression("/", false) }
        findViewById<Button>(R.id.btn_open).setOnClickListener { appendOnExpression("(", false) }
        findViewById<Button>(R.id.btn_close).setOnClickListener { appendOnExpression(")", false) }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val string = expression.text.toString()
            if (string.isNotEmpty()) {
                expression.text = string.substring(0, string.length - 1)
            }
            result.text = ""
        }

        findViewById<Button>(R.id.btn_ac).setOnClickListener {
            expression.text = ""
            result.text = ""
        }

        findViewById<Button>(R.id.btn_equal).setOnClickListener {
            try {
                val expressionString = expression.text.toString()
                val expression = ExpressionBuilder(expressionString).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    this.result.text = longResult.toString()
                else
                    this.result.text = result.toString()
            } catch (e: Exception) {
                this.result.text = "Error"
            }
        }
    }

    private fun appendOnExpression(string: String, canClear: Boolean) {
        if (result.text.isNotEmpty()) {
            expression.text = ""
        }

        if (canClear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}
