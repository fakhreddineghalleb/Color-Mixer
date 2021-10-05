package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

const val RED = "RED"
const val BLUE = "BLUE"
const val YELLOW = "YELLOW"
const val PURPLE = "PURPLE"
const val GREEN = "GREEN"
const val ORANGE = "ORANGE"

const val NAME = "NAME"
const val MIXED_COLOR = "COLOR"
const val COLOR1 = "COLOR 1"
const val COLOR2 = "COLOR 2"

class MainActivity : AppCompatActivity() {

    private var cbRed : CheckBox? = null
    private var cbBlue : CheckBox? = null
    private var cbYellow : CheckBox? = null
    private var btnMix : Button? = null
    private var editTextName : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbBlue = findViewById(R.id.cbBlue)
        cbYellow = findViewById(R.id.cbYellow)
        cbRed = findViewById(R.id.cbRed)
        btnMix = findViewById(R.id.btnMix)
        editTextName = findViewById(R.id.editTextName)

        btnMix!!.setOnClickListener{
            mixColor()
        }
    }

    fun mixColor(){

        if (editTextName!!.text.isEmpty()) {
            Toast.makeText(this, "You must enter your name !", Toast.LENGTH_SHORT).show()
            return
        }

        var colorMixed = "NONE"
        var color1 = "NONE"
        var color2 = "NONE"
        val name = editTextName!!.text.toString()

        if (cbBlue!!.isChecked && cbRed!!.isChecked && cbYellow!!.isChecked){
            Toast.makeText(this, "You must choose 2 colors !", Toast.LENGTH_SHORT).show()
            return
        }else if (cbBlue!!.isChecked && cbRed!!.isChecked){
            colorMixed = PURPLE
            color1 = BLUE
            color2 = RED
        }else if (cbBlue!!.isChecked && cbYellow!!.isChecked){
            colorMixed = GREEN
            color1 = BLUE
            color2 = YELLOW
        }else if (cbYellow!!.isChecked && cbRed!!.isChecked){
            colorMixed = ORANGE
            color1 = YELLOW
            color2 = RED
        }else{
            Toast.makeText(this, "You must choose 2 colors !", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(NAME, name)
            putExtra(MIXED_COLOR, colorMixed)
            putExtra(COLOR1, color1)
            putExtra(COLOR2, color2)
        }

        startActivity(intent)
    }
}