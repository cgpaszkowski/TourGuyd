package com.example.tourguyd

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        register.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        if (usernameRG.text.toString().isEmpty()) {
            usernameRG.error = "Please Enter Your Email"
            usernameRG.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(usernameRG.text.toString()).matches()) {
            usernameRG.error = "Please Enter A Valid Email"
            usernameRG.requestFocus()
            return
        }

        if (passwordRG.text.toString().isEmpty()) {
            passwordRG.error = "Please Enter Your Password"
            passwordRG.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(usernameRG.text.toString(), passwordRG.text.toString()).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(Intent(this,LoginActivity::class.java))
                                finish()
                            }
                    }
                }

                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Registration failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}