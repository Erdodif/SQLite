package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.example.sqlite.databinding.ActivityDeleteBinding


class DeleteActivity : AppCompatActivity() {
    private var torlesID: EditText? = null
    private var btnTorles: Button? = null
    private var btnVissza: Button? = null
    private var adatbazis: DBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnTorles.setOnClickListener{
            val id = bind.torlesId.text.toString()
        }
    }
}