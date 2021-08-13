package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
  private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
           DatePickerDialog.OnDateSetListener { view, year, month, DayOfMonth ->

            Toast.makeText(this,"DISPLAY", Toast.LENGTH_LONG).show()

            val selectedDate = "$DayOfMonth/${month+1}/$year"

            binding.tvSelectDate.setText(selectedDate)
               val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

               val theDate = sdf.parse(selectedDate)

               val selectedDateInMinutes = theDate!!.time/60000

               val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

               val currentDateInMinutes = currentDate!!.time/60000

               val difference = currentDateInMinutes - selectedDateInMinutes

               binding.tvSelectedDateInMinutes.setText(difference.toString())

            }
            ,year
            , month
            , day).show()
    }
}