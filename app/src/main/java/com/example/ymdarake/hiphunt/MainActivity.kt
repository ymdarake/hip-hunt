package com.example.ymdarake.hiphunt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var prevText = "start"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val input: String = editText.text.toString()
            if (input.startsWith(prevText.drop(prevText.length - 1))) {
                Toast.makeText(this, "いいね：" + input, Toast.LENGTH_LONG).show()
                previous.setText(input)
                prevText = input
            }
            else {
                Toast.makeText(this, "やりなおし", Toast.LENGTH_LONG).show()
            }
        }
    }
}
