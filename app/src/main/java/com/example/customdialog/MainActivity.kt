package com.example.customdialog

import android.app.Dialog
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customdialog.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.customdialog)
            dialog.setCancelable(false)
            val window = dialog.window
            window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.findViewById<TextView>(R.id.positiveButton).setOnClickListener {
                val name = dialog.findViewById<EditText>(R.id.etName)
                val etLayout = dialog.findViewById<TextInputLayout>(R.id.textInputLayout)
                name.clearFocus()
                if(name.text.toString() == ""){
                    etLayout.error = "Enter Name.."
                }
                else{
                    Toast.makeText(this@MainActivity,"You Entered: "+name.text,Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }
}