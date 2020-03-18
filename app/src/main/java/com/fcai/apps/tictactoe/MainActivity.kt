package com.fcai.apps.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun isClicked(view:View){
        // knowing which button is clicked
        val button = view as Button
        var choice = 0
        when(button.id){
            R.id.button1 -> choice = 1
            R.id.button2 -> choice = 2
            R.id.button3 -> choice = 3
            R.id.button4 -> choice = 4
            R.id.button5 -> choice = 5
            R.id.button6 -> choice = 6
            R.id.button7 -> choice = 7
            R.id.button8->  choice = 8
            R.id.button9 -> choice = 9
        }
        playGame(choice , button)
    }
    fun playGame(choice : Int , button : Button){
        if (ActivePlayer == 1){
            button.setText("X")
            button.setBackgroundResource(R.color.skyBlue)
            player1.add(choice)
            if (findWinner(player1)){
                Toast.makeText(this,"player1 won the game !",Toast.LENGTH_LONG).show()
                finish()
            }
            else {
                ActivePlayer = 2
            }
        }
        else{
            button.setText("O")
            button.setBackgroundResource(R.color.colorAccent)
            player2.add(choice)
            if (findWinner(player2)){
                Toast.makeText(this,"player1 won the game !",Toast.LENGTH_LONG).show()
                finish()
            }
            ActivePlayer = 1

        }
        button.isEnabled = false
    }
    fun findWinner(player : ArrayList<Int>):Boolean{
        // check for row 1
        if (player.contains(1)&&player.contains(2)&&player.contains(3)){
            return true
        }
        // check for row 2
        else if (player.contains(4)&&player.contains(5)&&player.contains(6)){
            return true
        }
        // for row 3
        else if (player.contains(7)&&player.contains(8)&&player.contains(9)){
            return true
        }
        //for column1
        else if (player.contains(1)&&player.contains(4)&&player.contains(7)){
            return true
        }
        // for column 2
        else if (player.contains(2)&&player.contains(5)&&player.contains(8)){
            return true
        }
        // for column 3
        else if (player.contains(3)&&player.contains(6)&&player.contains(9)){
            return true
        }
        // for diagonal 1
        else if (player.contains(1)&&player.contains(5)&&player.contains(9)){
            return true
        }
        // for diagonal 2
        else if (player.contains(3)&&player.contains(5)&&player.contains(7)){
            return true
        }
        else{
            return false
        }
    }
}
