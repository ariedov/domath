package com.dleibovych.domath.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.dleibovych.domath.Operation

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.intro).visibility = View.VISIBLE
        findViewById<View>(R.id.problem).visibility = View.GONE

        findViewById<Button>(R.id.practiceMode).setOnClickListener {
            findViewById<View>(R.id.intro).visibility = View.GONE
            findViewById<View>(R.id.problem).visibility = View.VISIBLE

            viewModel.practice()
        }

        findViewById<Button>(R.id.one).setOnClickListener { viewModel.submitDigit("1") }
        findViewById<Button>(R.id.two).setOnClickListener { viewModel.submitDigit("2") }
        findViewById<Button>(R.id.three).setOnClickListener { viewModel.submitDigit("3") }
        findViewById<Button>(R.id.four).setOnClickListener { viewModel.submitDigit("4") }
        findViewById<Button>(R.id.five).setOnClickListener { viewModel.submitDigit("5") }
        findViewById<Button>(R.id.six).setOnClickListener { viewModel.submitDigit("6") }
        findViewById<Button>(R.id.seven).setOnClickListener { viewModel.submitDigit("7") }
        findViewById<Button>(R.id.eight).setOnClickListener { viewModel.submitDigit("8") }
        findViewById<Button>(R.id.nine).setOnClickListener { viewModel.submitDigit("9") }
        findViewById<Button>(R.id.zero).setOnClickListener { viewModel.submitDigit("0") }
        findViewById<Button>(R.id.minus).setOnClickListener { viewModel.submitNegative() }
        findViewById<Button>(R.id.remove).setOnClickListener { viewModel.backspace() }
        findViewById<Button>(R.id.submit).setOnClickListener { viewModel.submitResult() }

        viewModel.nextProblem.observe(this) { problem ->
            findViewById<TextView>(R.id.first).text = problem.left.toString()
            findViewById<TextView>(R.id.operation).text = problem.operation.string()
            findViewById<TextView>(R.id.second).text = problem.right.toString()
        }

        viewModel.result.observe(this) { result ->
            findViewById<TextView>(R.id.suggestedResult).text = result?.toString()
        }

        viewModel.total.observe(this) { total ->
            findViewById<TextView>(R.id.total).text = total
        }
    }

    private fun Operation.string(): String {
        return when (this) {
            Operation.Addition -> "+"
            Operation.Division -> "/"
            Operation.Multiplication -> "*"
            Operation.Subtraction -> "-"
        }
    }
}
