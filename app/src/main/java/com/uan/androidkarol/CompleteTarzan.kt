package com.uan.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_tarzan.*
import java.util.*

class CompleteTarzan : AppCompatActivity() {

    val nounToFilling = "<noun>"
    val pluralnounToFilling = "<plural-noun>"
    val adjectiveToFilling = "<adjective>"
    val placeToFilling = "<place>"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_tarzan)

        buttonContinuew.setOnClickListener {

            val continueButton = Intent (this, ViewHistory::class.java)
            continueButton.putExtra("tale",CompleteHistory() )
            continueButton.putExtra("title_tale", "Tarzan Tale")
            startActivity(continueButton)
        }
    }
    fun CompleteHistory():String{


        var noun = editTextNoun.text.toString()
        var pluralNoun=editTextPluralNoun.text.toString()
        var history= readHistory()
        var adjective=editTextAdjetive.text.toString()
        var place = editTextPlace.text.toString()


        var newAdjective = history.replace(adjectiveToFilling,adjective,true)
        var newPlace = newAdjective.replace(placeToFilling,place, true)
        var newNoun = newPlace.replace(nounToFilling,noun,true)
        val newHistory = newNoun.replace(pluralnounToFilling, pluralNoun ,true)

        return newHistory

    }

    fun readHistory(): String {
        val scannerTale= Scanner(resources.openRawResource(R.raw.madlib1_tarzan))
        var tale = ""
        while (scannerTale.hasNextLine()){

            val lineTale =scannerTale.nextLine()
            tale += lineTale
        }
        scannerTale.close()
        return tale
    }




}
