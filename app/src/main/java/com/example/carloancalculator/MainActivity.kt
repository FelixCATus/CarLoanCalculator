package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

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

        carLoan.text = (carPrice.text.toString().toDouble() - downPayment.text.toString().toDouble()).toString()
        interest.text = (carLoan.text.toString().toDouble() * interestRate.text.toString().toDouble() * loanPeriod.text.toString().toInt()).toString()
        monthlyPayment.text = ((carLoan.text.toString().toDouble() + interest.text.toString().toDouble()) / loanPeriod.text.toString().toInt() / 12).toString()

        carLoan.visibility = View.VISIBLE
        interest.visibility = View.VISIBLE
        monthlyPayment.visibility = View.VISIBLE
    }
}
