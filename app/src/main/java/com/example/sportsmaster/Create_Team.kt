package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class Create_Team : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_team)

        val letsStartBtn=findViewById<Button>(R.id.letsStartBtn)
        val backbtn1=findViewById<ImageView>(R.id.backbtn1)

        val seekBar1=findViewById<SeekBar>(R.id.seekBar1)
        val seekBar2=findViewById<SeekBar>(R.id.seekBar2)
        val seekBar3=findViewById<SeekBar>(R.id.seekBar3)
        val seekBar4=findViewById<SeekBar>(R.id.seekBar4)

        val seekBarTxt1=findViewById<TextView>(R.id.seekBarTxt1)
        val seekBarTxt2=findViewById<TextView>(R.id.seekBarTxt2)
        val seekBarTxt3=findViewById<TextView>(R.id.seekBarTxt3)
        val seekBarTxt4=findViewById<TextView>(R.id.seekBarTxt4)

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                seekBarTxt1.setText("$progress");
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                seekBarTxt2.setText("$progress");
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        seekBar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                seekBarTxt3.setText("$progress");
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        seekBar4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                seekBarTxt4.setText("$progress");
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        letsStartBtn.setOnClickListener {
            val intent=Intent(this,Select_Players::class.java)
            startActivity(intent)
        }

        backbtn1.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}