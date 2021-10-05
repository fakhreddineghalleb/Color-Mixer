package tn.esprit.colormixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FailureActivity : AppCompatActivity() {
    private var btnQuit : Button? = null
    private var txtName : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)

        title = "Failure"

        btnQuit = findViewById(R.id.btnQuit)
        txtName = findViewById(R.id.txtName)

        txtName!!.text = "Sorry "+intent.getStringExtra(NAME).toString()+" !"

        btnQuit!!.setOnClickListener {
            finish()
        }
    }
}