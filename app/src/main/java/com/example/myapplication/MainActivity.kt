package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var startGameButton: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var tvSkor: TextView
    private var oyuncu1Skor = 0
    private var oyuncu2Skor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        updateSkor()
    }

    private fun initUI() {
        textView = findViewById(R.id.textView)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        startGameButton = findViewById(R.id.startGameButton)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        tvSkor = findViewById(R.id.tvSkor)
        button1.isEnabled = false
        button2.isEnabled = false

        startGameButton.setOnClickListener {
            if(editText1.text.trim().isNullOrEmpty()) {
            Toast.makeText (this, getString (R. string. uyari_mesaj), Toast.LENGTH_SHORT).show()
        } else if (editText2.text.trim().isNullOrEmpty()){
            Toast.makeText (this, getString (R. string. uyari_mesaj), Toast.LENGTH_SHORT).show()
            } else {
                val oyuncu1Ad: String = editText1.text.toString()
                val oyuncu2Ad: String = editText2.text.toString()
                button1.text = "$oyuncu1Ad kazandı"
                button2.text = "$oyuncu2Ad kazandı"
                editText1.isEnabled = false
                editText2.isEnabled = false
                button1.isEnabled = true
                button2.isEnabled = true
            }
        }

        button1.setOnClickListener {
            oyuncu1Skor++
            updateSkor()
            if(oyuncu1Skor == 5){
                val intent = Intent(this, ResultActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Intent.EXTRA_TEXT, editText1.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

        button2.setOnClickListener {
            oyuncu2Skor++
            updateSkor()
            if(oyuncu2Skor == 5){
                val intent = Intent(this, ResultActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Intent.EXTRA_TEXT, editText2.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }

    private fun updateSkor(){
        val skorText = "$oyuncu1Skor - $oyuncu2Skor"
        tvSkor.text = skorText
    }

}