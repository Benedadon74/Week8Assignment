package edu.rvc.student.week8assignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPage2 = findViewById<Button>(R.id.btnPage2)

        btnPage2.setOnClickListener(View.OnClickListener {
            //Intent is used to send data between activities
            val intent = Intent(this, Main2Activity::class.java)
            //putExtra sets value to name SendStuff (Could be called whatever you want
            intent.putExtra("SendStuff",txtName.text.toString())
            intent.putExtra("SendStuff2",txtEmail.text.toString())
            //Go to second activity
            startActivity(intent)

            txtName.getText().clear();
            txtEmail.getText().clear();
        })
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}