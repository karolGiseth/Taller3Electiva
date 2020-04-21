package com.uan.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Welcome()

        listTales.setOnItemClickListener { _, item, _, _ ->
            val text = item as TextView

            when(text.text.toString()){

                "Tarzan Tale"->{val started = Intent(this, CompleteTarzan::class.java)
                                     startActivity(started)}

            }

        }

    }



    fun Welcome(){
        var conditionText= ""
        val scanner =Scanner(resources.openRawResource(R.raw.welcome))
        while (scanner.hasNextLine()){
            val lineText = scanner.nextLine()
            conditionText += lineText
        }
        textWelcome.setText(conditionText)
        scanner.close()
    }
}
