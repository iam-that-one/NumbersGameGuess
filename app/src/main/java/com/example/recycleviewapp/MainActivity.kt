package com.example.recycleviewapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var add : Button
    lateinit var txt : EditText
    lateinit var lbl : TextView
    lateinit var  lbl1 : TextView
    lateinit var clear : Button
    var message = ""
    lateinit var students : ArrayList<String>
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.editTextTextPersonName3)
        students = ArrayList()
        add = findViewById(R.id.button2)
        lbl1 = findViewById(R.id.textView)
        clear = findViewById(R.id.button1)
        clear.alpha = 0F
      //  lbl = findViewById(R.id.textView6)

        val myRV = findViewById<RecyclerView>(R.id.rvMain)
        myRV.adapter = RecycleViewAddapter(students)
        myRV.layoutManager = LinearLayoutManager(this)
        var ans = ""
        var rand = 0

        lbl1.text = "Guess the correct number [***]"
        clear.setOnClickListener{
            lbl1.text = "Guess the correct number [***]"
          //  students =  mutableListOf("")
            students.add("----------------------------------------------------")
            clear.alpha = 0F
            students.clear()
            myRV.adapter?.notifyDataSetChanged()
        }
        add.setOnClickListener {
             ans = txt.text.toString()
             rand = Random.nextInt(101)
            if(ans == rand.toString()){
                lbl1.text = "Guess the correct number [Unlocked] [${ans}]"
                students.add("Your guss is ${ans}, You got it!! 😊")

                clear.alpha = 1F

            }else{

                students.add("Sorry!! Wrong guess 😐")

            }
            myRV.adapter?.notifyDataSetChanged()
            txt.text.clear()

        }
        println(students)
    }
}