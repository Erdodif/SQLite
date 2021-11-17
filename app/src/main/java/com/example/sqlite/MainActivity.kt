package com.example.sqlite

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.buttonCreate.setOnClickListener {
            FCompanion.atter(this, CreateActivity())
        }
        bind.buttonUpdate.setOnClickListener {
            FCompanion.atter(this, UpdateActivity())
        }
        bind.buttonRead.setOnClickListener {
            val db = DBHelper(this)
            val kurzor: Cursor = db.listaz()
            val list = StringBuilder()
            while (kurzor.moveToNext()) {
                kurzor.moveToNext()
                list.append("ID: " + kurzor.getInt(0))
                list.append("Vezetéknév: " + kurzor.getString(1))
                list.append("Keresztnév: " + kurzor.getString(2))
                list.append("Jegy: " + kurzor.getString(3))
            }
            bind.textViewList.text = list.toString()
        }
        bind.buttonDelete.setOnClickListener {
            FCompanion.atter(this, DeleteActivity())
        }
    }
}