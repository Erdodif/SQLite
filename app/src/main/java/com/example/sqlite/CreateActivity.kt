package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite.databinding.ActivityCreateBinding
import java.lang.Exception
import java.lang.NumberFormatException
import java.util.concurrent.ExecutionException

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val db = DBHelper(this)
        bind.buttonCreate.setOnClickListener {
            try {
                val vnev = bind.editLName.editText.toString()
                val knev = bind.editFName.editText.toString()
                val jegy = Integer.parseInt(bind.editGrade.editText.toString())
                if (jegy>5) throw NumberFormatException("A jegy nem lehet nagyobb 5-nél!")
                if(jegy<1) throw NumberFormatException("A jegy nem lehet kissebb 1-nél!")
                if(knev.length<3) throw Exception("A keresztnév nem lehet rövidebb mint 3!")
                if(knev.length>25) throw Exception("A keresztnév nem lehet rhosszabb mint 25!")
                if(knev.length<3) throw Exception("A vezetéknév nem lehet rövidebb mint 3!")
                if(knev.length>25) throw Exception("A vezetéknév nem lehet hosszabb mint 25!")
                db.rogzites(vnev,knev,jegy)
            } catch (e :Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}