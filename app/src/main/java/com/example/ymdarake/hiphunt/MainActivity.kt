package com.example.ymdarake.hiphunt

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pingpong: MediaPlayer
    private lateinit var boo: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init
        var prevText = previous.text.toString()
        pingpong = MediaPlayer.create(this, R.raw.pinpon)
        boo = MediaPlayer.create(this, R.raw.boo)

        button.setOnClickListener {
            val input: String = editText.text.toString()
            if (input.startsWith(prevText.drop(prevText.length - 1))) {
                if (pingpong.isPlaying) {
                    pingpong.seekTo(0)
                }
                pingpong.start()
                Toast.makeText(this, "いいね：" + input, Toast.LENGTH_SHORT).show()
                previous.setText(input)
                prevText = input
                editText.setText("")
                counter.setText((counter.text.toString().toInt() + 1).toString())
            }
            else {
                if (boo.isPlaying) {
                    boo.seekTo(0)
                }
                boo.start()
                Toast.makeText(this, "やりなおし", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        pingpong.release()
        boo.release()
    }

}
