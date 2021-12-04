package com.example.incorrect_warehouse_mobile_app.model

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class PostgreSqlDatabase {

    private val ip="169.254.147.180:5432"
    private val db="pi"
    private val username="pi"
    private val password="raspberry"

    fun dbConn(querry : String) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString : String? = null
        try{
            Class.forName("org.postgresql.Driver")
            connString ="jdbc:postgresql://$ip/$db?user=$username&password=$password"
            conn = DriverManager.getConnection(connString)
        }catch (ex : SQLException){
            Log.e("SQLERROR: " , ex.message!!)
        }
        catch (ex1 :ClassNotFoundException){
            Log.e("ERROR :", ex1.message!!)
        }
        catch (ex2 :Exception){
            Log.e("Error :", ex2.message!!)
        }
        Log.d("TEST",conn?.isValid(10).toString())
    }

}