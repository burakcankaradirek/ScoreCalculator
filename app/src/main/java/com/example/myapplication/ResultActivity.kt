package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var textView2: TextView
    private lateinit var resetGameButton: Button
    private lateinit var tvTebrik: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initUI()
        kazananKisi()
    }
    private fun initUI(){
        textView2 = findViewById(R.id.textView2)
        tvTebrik = findViewById(R.id.tvTebrik)
        resetGameButton = findViewById(R.id.resetGameButton)

        resetGameButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
    private fun kazananKisi(){
        val kazanan = intent.extras?.getString(Intent.EXTRA_TEXT)
        textView2.setText(kazanan)
    }
}