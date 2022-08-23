package com.example.nluc21dialoge

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btnAlart.setOnClickListener {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.setTitle("Delete Post")
        alertDialog.setMessage("Are You Sure To Delete Post ?")
        alertDialog.setIcon(R.drawable.ic_delete)

        alertDialog.setCancelable(false)

        alertDialog.setPositiveButton("yes"){d,i ->
            Toast.makeText(this , "Yes" , Toast.LENGTH_SHORT).show()
        }
        alertDialog.setNegativeButton("No"){d,i ->
        Toast.makeText(this , "No" , Toast.LENGTH_SHORT).show()
            d.cancel()
        }
        alertDialog.setNeutralButton("Rete My"){d,i ->
            Toast.makeText(this , "Rate my" ,Toast.LENGTH_SHORT).show()
        }
        alertDialog.create().show()
    }

        txtDate.setOnClickListener {
            val currentDate = Calendar.getInstance()

            val day = currentDate.get(Calendar.DAY_OF_MONTH)
            val month = currentDate.get(Calendar.MONTH)
            val year = currentDate.get(Calendar.YEAR)

            val picker = DatePickerDialog(this ,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                txtDate.setText("$year / ${month+1} / $dayOfMonth") }
                ,year , month , day
                )
            picker.show()
        }


        txtTime.setOnClickListener {
            val currentTime = Calendar.getInstance()

            val hour = currentTime.get(Calendar.HOUR)
            val minute = currentTime.get(Calendar.MINUTE)

            val pickerTime = TimePickerDialog(this , TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                txtTime.setText("$hourOfDay : $minute")
            } ,
                hour , minute , false)

            pickerTime.show()
        }

    }
}