package com.example.challenge2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.net.Uri
import android.widget.Toast
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var usernameInput : String = ""
    private var passwordInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        getData()
        btnLogin.setOnClickListener { validationInput() }
        btnSkip.setOnClickListener { navigationToMainActivity() }
        btnSignUp.setOnClickListener { navigationToRegisterActivity() }
    }
    private fun getData() {
        val bundle = intent.extras
        val username = bundle?.getString("username")
        val password = bundle?.getString("password")
    }
    private fun navigationToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigationToRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
    private fun dataRegister() {
        val intent = Intent(this, MainActivity::class.java)
        val bundledata = Bundle()
        val bundle = intent.extras
        val dataname = bundle?.getString("name")
        val datausername = bundle?.getString("username")
        val dataemail = bundle?.getString("email")
        val datatelephone = bundle?.getString("telephone")
        val dataaddress = bundle?.getString("address")
        val datapassword = bundle?.getString("password")
        bundledata.putString("name", dataname)
        bundledata.putString("username", datausername)
        bundledata.putString("email", dataemail)
        bundledata.putString("telephone", datatelephone)
        bundledata.putString("address", dataaddress)
        bundledata.putString("password", datapassword)
        intent.putExtras(bundledata)
        startActivity(intent)
    }
    private fun validationInput(){
        val bundle = intent.extras
        usernameInput = usernameLog.text.toString()
        passwordInput = passwordLog.text.toString()
        when {
            usernameInput.isEmpty() -> usernameLog.error = "Username cannot be empty"
            passwordInput.isEmpty() -> passwordLog.error = "Password cannot be empty"
            else -> {
                val datausername = bundle?.getString("username")
                val datapassword = bundle?.getString("password")
                if(usernameInput == datausername && passwordInput == datapassword) {
                    tampilToast("Navigation to Main Activity")
                    dataRegister()
                }else {
                    tampilToast("Failed")
                }
            }
        }
    }
    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
