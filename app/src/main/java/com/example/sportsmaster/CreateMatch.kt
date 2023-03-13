package com.example.sportsmaster

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.TimePicker
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class CreateMatch : AppCompatActivity() {

    var cal = Calendar.getInstance()
    var dateTxt: TextView? = null
    var dateTimeInput: LinearLayout? = null

    var timeInput: LinearLayout? = null
    var timePicker: TimePicker? = null
    var timeTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_match)

        dateTxt = this.findViewById(R.id.dateTxt)
        dateTimeInput = this.findViewById(R.id.dateTimeInput)

        timeInput = this.findViewById(R.id.timeInput)
        timePicker = this.findViewById(R.id.timePicker)
        timeTxt = this.findViewById(R.id.timeTxt)

        val selectStarPlayerBackBtn=findViewById<ImageView>(R.id.selectStarPlayerBackBtn)
        selectStarPlayerBackBtn.setOnClickListener {
            val intent=Intent(this,StarPlayer::class.java)
            startActivity(intent)
        }

        val letsStartBtn=findViewById<Button>(R.id.letsStartBtn)
        letsStartBtn.setOnClickListener {
            val intent=Intent(this,CreatePlayer::class.java)
            startActivity(intent)
        }

        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                timeTxt!!.setText(String.format("%d : %d", hourOfDay, minute))
            }
        }, hour, minute, false)

        timeTxt!!.setOnClickListener({ v ->
            mTimePicker.show()
        })


        setOnClickable()



        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        dateTimeInput!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@CreateMatch,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        })



    }
    private fun setOnClickable() {
//        timeInput?.setOnClickListener {
//            timePicker?.visibility = View.VISIBLE
//        }
        if(timeTxt!= null) {
            timeInput?.setOnClickListener {
                timePicker?.visibility = View.VISIBLE
            }
        }
        else {
            Handler().postDelayed({
                timePicker?.visibility = View.GONE

            }, 2000)
//            timePicker?.visibility = View.GONE

        }
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        dateTxt?.text = sdf.format(cal.getTime())
    }


}




































































//class CreateMatch : AppCompatActivity() {
//
//    var cal = Calendar.getInstance()
//    private var timeInput=findViewById<LinearLayout>(R.id.timeInput)
//    private var timePicker=findViewById<TimePicker>(R.id.timePicker)
//    private var timeTxt=findViewById<TextView>(R.id.timeTxt)
//    private var dateTimeInput=findViewById<LinearLayout>(R.id.dateTimeInput)
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create_match)
//
//        onClickTime1()
//
////        var dateTimeInput=findViewById<LinearLayout>(R.id.dateTimeInput)
////        var timeInput=findViewById<LinearLayout>(R.id.timeInput)
////        var timePicker=findViewById<TimePicker>(R.id.timePicker)
//
//
//        timeInput.setOnClickListener {
//            timePicker.visibility=View.VISIBLE
//        }
//
//        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
//                                   dayOfMonth: Int) {
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInView()
//            }
//        }
//
//        dateTimeInput.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View) {
//                DatePickerDialog(this@CreateMatch,
//                    dateSetListener,
//                    // set DatePickerDialog to point to today's date when it loads up
//                    cal.get(Calendar.YEAR),
//                    cal.get(Calendar.MONTH),
//                    cal.get(Calendar.DAY_OF_MONTH)).show()
//            }
//
//        })
//    }
//
//    private fun onClickTime1() {
////        var timePicker=findViewById<TimePicker>(R.id.timePicker)
////        var timeTxt=findViewById<TextView>(R.id.timeTxt)
//
//        timePicker.setOnTimeChangedListener { _, hour, minute ->
//            var hour = hour
//            var am_pm = ""
//            // AM_PM decider logic
//            when {
//                hour == 0 -> {
//                    hour += 12
//                    am_pm = "AM"
//                }
//                hour == 12 -> am_pm = "PM"
//                hour > 12 -> {
//                    hour -= 12
//                    am_pm = "PM"
//                }
//                else -> am_pm = "AM"
//            }
//            if (timeTxt != null) {
//                val hour = if (hour < 10) "0" + hour else hour
//                val min = if (minute < 10) "0" + minute else minute
//                // display format of time
//                val msg = "Time is: $hour : $min $am_pm"
//                timeTxt.text = msg
//                timeTxt.visibility = ViewGroup.VISIBLE
//            }
//        }
//    }
//
//    private fun updateDateInView() {
//        var dateTxt=findViewById<TextView>(R.id.dateTxt)
//        val myFormat = "dd/MM/yyyy" // mention the format you need
//        val sdf = SimpleDateFormat(myFormat, Locale.US)
//        dateTxt.text = sdf.format(cal.getTime())
//    }
//
//}