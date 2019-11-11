package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculate = findViewById<Button>(R.id.btnCalculate)
        calculate.setOnClickListener { calculate() }
    }

    private fun calculate(){
        val carPrice = findViewById<TextView>(R.id.editCarPrice)
        val downPayment = findViewById<TextView>(R.id.editDownPaymentAmount)
        val loanPeriod = findViewById<TextView>(R.id.editLoanPeriod)
        val interestRate = findViewById<TextView>(R.id.editInterestRate)

        val carLoan: TextView = findViewById(R.id.carLoan)
        val interest: TextView = findViewById(R.id.interest)
        val monthlyPayment: TextView = findViewById(R.id.monthlyRepayment)

        if(carPrice.text.isNotEmpty() || downPayment.text.isNotEmpty() || loanPeriod.text.isNotEmpty() || interestRate.text.isNotEmpty()){
            carLoan.text = (carPrice.text.toString().toDouble() - downPayment.text.toString().toDouble()).toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
            interest.text = (carLoan.text.toString().toDouble() * (interestRate.text.toString().toDouble() / 100) * loanPeriod.text.toString().toInt()).toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
            monthlyPayment.text = ((carLoan.text.toString().toDouble() + interest.text.toString().toDouble()) / loanPeriod.text.toString().toInt() / 12).toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()

            carLoan.visibility = View.VISIBLE
            interest.visibility = View.VISIBLE
            monthlyPayment.visibility = View.VISIBLE
        }
    }
}
