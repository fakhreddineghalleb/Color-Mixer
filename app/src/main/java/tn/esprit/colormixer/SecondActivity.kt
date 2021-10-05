package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private var rbPurple : RadioButton? = null
    private var rbGreen : RadioButton? = null
    private var rbOrange : RadioButton? = null
    private var btnSubmit : Button? = null
    private var txtChoosed : TextView? = null

    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        title = "Choose your answer"

        rbPurple = findViewById(R.id.rbPurple)
        rbGreen = findViewById(R.id.rbGreen)
        rbOrange = findViewById(R.id.rbOrange)

        btnSubmit = findViewById(R.id.btnSubmit)
        txtChoosed = findViewById(R.id.txtChoosed)

        correctColor = intent.getStringExtra(MIXED_COLOR).toString()
        name = intent.getStringExtra(NAME).toString()

        color1 = intent.getStringExtra(COLOR1).toString()
        color2 = intent.getStringExtra(COLOR2).toString()

        txtChoosed!!.text = "You choosed "+ color1 + " and " + color2

        btnSubmit!!.setOnClickListener {
            if (checkAnswer()){
                val intent = Intent(this, SuccessActivity::class.java).apply {
                    putExtra(NAME, name)
                    putExtra(MIXED_COLOR, correctColor)
                    putExtra(COLOR1, color1)
                    putExtra(COLOR2, color2)
                }

                startActivity(intent)
            }else{
                val intent = Intent(this, FailureActivity::class.java).apply {
                    putExtra(NAME, name)
                    putExtra(MIXED_COLOR, correctColor)
                    putExtra(COLOR1, color1)
                    putExtra(COLOR2, color2)
                }

                startActivity(intent)
            }

            finish()
        }

    }

    fun checkAnswer(): Boolean{

        if(rbGreen!!.isChecked && correctColor.equals(GREEN)){
            return true
        }else if (rbOrange!!.isChecked && correctColor.equals(ORANGE)){
            return true
        }else if (rbPurple!!.isChecked && correctColor.equals(PURPLE)){
            return true
        }

        return false
    }
}