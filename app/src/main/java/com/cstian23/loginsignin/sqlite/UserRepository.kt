package com.cstian23.loginsignin.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.cstian23.loginsignin.models.User

class UserRepository(context: Context) {
    private val database: SQLiteDatabase = DbHelper(context).writableDatabase

    fun addUser(user: User): Long {
        val contentValues = ContentValues()
        contentValues.put(DbHelper.COL_USERNAME, user.username)
        contentValues.put(DbHelper.COL_EMAIL, user.email)
        contentValues.put(DbHelper.COL_PASSWORD, user.password)

        return database.insert(DbHelper.TABLE_NAME, null, contentValues)
    }

    @SuppressLint("Range")
    fun getUser(email: String): User? {
        val query = "SELECT * FROM ${DbHelper.TABLE_NAME} WHERE ${DbHelper.COL_EMAIL} = ?"
        val cursor: Cursor = database.rawQuery(query, arrayOf(email))
        return if (cursor.moveToFirst()) {
            User(
                cursor.getInt(cursor.getColumnIndex(DbHelper.COL_ID)),
                cursor.getString(cursor.getColumnIndex(DbHelper.COL_USERNAME)),
                cursor.getString(cursor.getColumnIndex(DbHelper.COL_EMAIL)),
                cursor.getString(cursor.getColumnIndex(DbHelper.COL_PASSWORD))
            )
        } else {
            null
        }
    }
}