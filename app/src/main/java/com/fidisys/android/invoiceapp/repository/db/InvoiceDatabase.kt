package com.fidisys.android.invoiceapp.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fidisys.android.invoiceapp.repository.data.Invoice

@Database(entities = [Invoice::class], version = 1, exportSchema = false)
abstract class InvoiceDatabase : RoomDatabase() {
    abstract fun invoiceDao(): InvoiceDao

    companion object {

        // volatile keyword here makes the database variable thread safe
        @Volatile
        private var INSTANCE: InvoiceDatabase? = null

        fun getDatabase(context: Context): InvoiceDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InvoiceDatabase::class.java, "invoice_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}