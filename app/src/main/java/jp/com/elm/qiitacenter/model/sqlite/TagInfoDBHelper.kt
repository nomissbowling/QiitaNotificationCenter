package jp.com.elm.qiitacenter.model.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TagInfoDBHelper(context: Context,
                      dbName : String,
                      factory: SQLiteDatabase.CursorFactory?,
                      version : Int
                      ): SQLiteOpenHelper(context,dbName,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS TagInfoTable (followers_count integer, icon_url text, tag_id text, items_count integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}