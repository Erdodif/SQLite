package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}