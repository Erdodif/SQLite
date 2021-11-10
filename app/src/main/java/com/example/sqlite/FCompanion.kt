package com.example.sqlite

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class FCompanion {
    companion object{
        fun atter (from : Activity, to:Activity, extraId: Int? = null){
            val intent = Intent(from,to::class.java)
            if (extraId !== null){
                intent.putExtra("id",extraId)
            }
            from.startActivity(intent)
            from.finish()
        }
    }
}