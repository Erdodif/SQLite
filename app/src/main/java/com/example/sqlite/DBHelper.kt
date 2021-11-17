package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    companion object {
        private val DB_NAME: String = "tanulok.db"
        private val DB_VER: Int = 1
        private val TABLE_NAME: String = "tanulok"
        private val COL_ID = "id"
        private val COL_VEZNEV = "vezeteknev"
        private val COL_KERNEV = "keresztnev"
        private val COL_JEGY = "jegy"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql: String = """CREATE TABLE $TABLE_NAME (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_VEZNEV TEXT NOT NULL,
                $COL_KERNEV TEXT NOT NULL,
                $COL_JEGY INTEGER NOT NULL)"""
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun rogzites(vnev: String, knev: String, jegy: Int): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COL_VEZNEV, vnev)
        values.put(COL_KERNEV, knev)
        values.put(COL_JEGY, jegy)
        return db.insert(TABLE_NAME, null, values).equals((-1).toLong())
    }

    fun listaz(): Cursor {
        val db: SQLiteDatabase = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun torles(id: String): Int {
        val db: SQLiteDatabase = writableDatabase
        return db.delete(TABLE_NAME, COL_ID + " = ?", arrayOf(id))
    }

    fun modosit(id: String, vnev: String, knev: String, jegy: Int): Int {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(COL_VEZNEV, vnev)
        values.put(COL_KERNEV, knev)
        values.put(COL_JEGY, jegy)
        return db.update(TABLE_NAME, values, "id = ?", arrayOf(id))
    }
}