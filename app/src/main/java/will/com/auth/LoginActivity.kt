package will.com.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import will.com.R
import will.com.data.Repository
import will.com.data.db.DbAccessor
import will.com.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    private var repository: Repository? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        repository = Repository(DbAccessor.db)
        signIn()

    }




    private fun signIn() {
        val email = findViewById<EditText>(R.id.emailEt)
        val password = findViewById<EditText>(R.id.passwordEt)
        val loginButton = findViewById<Button>(R.id.LoginBtn)

        loginButton.setOnClickListener() {
            if (email.text.toString().isNullOrEmpty() || password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Username or Password is not provided", Toast.LENGTH_LONG).show()
            }
            else if (repository?.fetchUser(email.text.toString(), password.text.toString())!= null) {


                    val intent = Intent ( this, DashboardActivity::class.java)
                    startActivity(intent)

            }

            else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show()
            }

        }
        binding?.SignUpTv?.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}

