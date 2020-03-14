package edu.rvc.student.week8assignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnBack = findViewById<Button>(R.id.btnBack)
      //  val txtShow = findViewById<TextView>(R.id.txtShow)
        val btnPage2 = findViewById<Button>(R.id.btnPage2)
        var txtName: String = intent.getStringExtra("SendStuff")
       var txtEmail: String = intent.getStringExtra("SendStuff2")
        var strShow: String = intent.getStringExtra("SendStuff") + " " + intent.getStringExtra("SendStuff2")

         txtShow.text = strShow

        btnBack.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
