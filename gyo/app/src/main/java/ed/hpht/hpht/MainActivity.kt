package ed.hpht.hpht

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val hips = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextView = findViewById<TextView>(R.id.editText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val hipCount = findViewById<TextView>(R.id.hipCount)
        val hipList = findViewById<TextView>(R.id.hipList)

        submitButton.setOnClickListener {
            val editText = editTextView.text.toString()

            if (isValidNextHip(hips, editText)) {
                hips.add(editText)
                val hipListCount = Integer.toString(hips.fold(0) { a, b -> a + 1 })
                val hipListText = hips.takeLast(5).reduce{ a, b -> "$b\n$a" }
                hipCount.text = hipListCount
                hipList.text = hipListText
                editTextView.text = ""
            }

        }

    }

    private fun isValidNextHip(hips: MutableList<String>, nextHip: String = ""): Boolean {
        return hips.size == 0 || hips.last()[hips.last().length - 1] == nextHip[0]
    }
}
