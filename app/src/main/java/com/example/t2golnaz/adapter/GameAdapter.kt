package com.example.t2golnaz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.t2golnaz.R
import com.example.t2golnaz.model.GameRound

class GameAdapter(context: Context, pets: List<GameRound>) :
    ArrayAdapter<GameRound>(context, 0, pets) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item, parent, false)

        val tvUser = view.findViewById<TextView>(R.id.tvUser)
        val tvPc = view.findViewById<TextView>(R.id.tvPC)
        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        val gameRound = getItem(position)
        gameRound?.let {
            tvUser.text = "User: "+it.userSelection.toString()
            tvPc.text = "Computer: "+it.pcSelection.toString()
            tvResult.text=it.result
        }

        return view
    }
}