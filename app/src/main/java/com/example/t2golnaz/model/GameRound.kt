package com.example.t2golnaz.model

class GameRound {
    var userSelection:Int
    var pcSelection:Int
    var result:String
    constructor(userSel:Int,pcSel:Int,resu:String)
    {
        this.userSelection=userSel
        this.pcSelection=pcSel
       this.result=resu
    }
}