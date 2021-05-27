package will.com.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import will.com.data.Repository
import will.com.data.db.DbAccessor
import will.com.data.db.Users
import will.com.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding? = null
    private var repository: Repository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        repository = Repository(DbAccessor.db)
        val user = repository?.fetchAllUsers()
        user?.forEach {
            Log.d("users", "" + it.email)
        }


        binding?.SignUpBtn?.setOnClickListener { view ->
            val username = binding?.usernameEt?.text.toString()
            val email = binding?.emailEt?.text.toString()
            val password = binding?.passwordEt?.text.toString()
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                    password
                )
            ) {
                Snackbar.make(view, "Fields must not be empty", Snackbar.LENGTH_LONG).show()
            } else {
                repository?.insertUser(Users(username, email, password))
                Snackbar.make(view, "Successfully registered", Snackbar.LENGTH_LONG).show()
            }
        }
        binding?.LoginTv?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}