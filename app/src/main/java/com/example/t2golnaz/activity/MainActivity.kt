package com.example.t2golnaz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.t2golnaz.R
import com.example.t2golnaz.adapter.GameAdapter
import com.example.t2golnaz.model.GameRound
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val TAG = this@MainActivity.toString()
    lateinit var gameAdapter : GameAdapter

    var numFromUI:Int=1
    var listOfGameRound= mutableListOf<GameRound>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSubmit = findViewById<Button>(R.id.btnSubmit)


        val spiUser: Spinner = findViewById<Spinner>(R.id.spiUser)
        /////**************//////////


        spiUser.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // An item was selected. You can retrieve the selected item using
                numFromUI=parent.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                numFromUI=-1
            }
        }
        ////////////////////

        btnSubmit.setOnClickListener {
            Log.d(TAG, "PLAY Button Pressed")

            if(numFromUI!=-1) {

                val pcSelction:Int = randomPCSelection()
                val result:String= gameResultCalculation(numFromUI,pcSelction)

                //Log.d(TAG, "You ${gameRound.result} !")

                val toast = Toast.makeText(this, "You ${result} !!!", Toast.LENGTH_LONG)
                toast.show()
            }
        }



        val gameRoundList:MutableList<GameRound>
                = listOfGameRound

        gameAdapter = GameAdapter(this, gameRoundList)

        val lvResults = findViewById<ListView>(R.id.lvResults)
        lvResults.adapter = gameAdapter
    }

    fun randomPCSelection():Int{
        return Random.nextInt(1,10)
    }

    fun gameResultCalculation(userSel: Int, pcSel:Int):String{
        var result:String
        if(userSel==pcSel)
            result= "Win"
        else
            result=  "Lose"

        val gameRound: GameRound = GameRound(userSel, pcSel,result)

        listOfGameRound.add(gameRound)

        this.gameAdapter.notifyDataSetChanged()

        return result
    }

}