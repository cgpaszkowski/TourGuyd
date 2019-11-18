package com.example.tourguyd

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        textRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

        login.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        if (usernameLI.text.toString().isEmpty()) {
            usernameLI.error = "Please Enter Your Email"
            usernameLI.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(usernameLI.text.toString()).matches()) {
            usernameLI.error = "Please Enter A Valid Email"
            usernameLI.requestFocus()
            return
        }

        if (passwordLI.text.toString().isEmpty()) {
            passwordLI.error = "Please Enter Your Password"
            passwordLI.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(usernameLI.text.toString(), passwordLI.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                }

                else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser : FirebaseUser?){
        if(currentUser != null) {
            if(currentUser.isEmailVerified){
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }
            else {
                Toast.makeText(
                    baseContext, "Invalid Email Address",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        else {
            Toast.makeText(
                baseContext, "Login Failed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}