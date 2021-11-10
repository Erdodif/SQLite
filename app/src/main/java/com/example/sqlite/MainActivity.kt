package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.buttonCreate.setOnClickListener {
            FCompanion.atter(this,CreateActivity())
        }
        bind.buttonUpdate.setOnClickListener {
            FCompanion.atter(this,UpdateActivity())
        }
    }
}