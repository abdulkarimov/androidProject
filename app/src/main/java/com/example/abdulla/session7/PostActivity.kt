package com.example.abdulla.session7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.abdulla.R
import com.example.abdulla.databinding.ActivityPostBinding
import com.example.abdulla.session7.model.Gender
import com.example.abdulla.session7.model.Status
import com.example.abdulla.session7.model.User
import com.example.abdulla.session7.retrofit.RetrofitClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.apply {
            gender.adapter = ArrayAdapter.createFromResource(
                this@PostActivity,
                R.array.spinner,
                android.R.layout.simple_spinner_item
            )

            registerButton.setOnClickListener()
            {
                val email = userEmail.text.toString()
                val name = name.text.toString()
                val id = userID.text.toString()
                val gender = Gender.valueOf(gender.selectedItem.toString())

                if (email.isNullOrEmpty() || name.isNullOrEmpty() || id.isNullOrEmpty())
                    return@setOnClickListener

                val user = User(id.toInt(), name, email, gender, Status.active)
                val intent = Intent(this@PostActivity , RxActivity::class.java)
               intent.putExtra(RxActivity.USER, Json.encodeToString(user))
                startActivity(intent)

            }
        }


    }

    private fun registerUser(user:User){
        binding.progressBar.visibility = View.VISIBLE

        RetrofitClient.createusers(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<User> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: User) {
                    hideProgress()
                    val intent = Intent(this@PostActivity, RxActivity::class.java)
                    startActivity(intent)
                }

                override fun onError(e: Throwable) {
                    hideProgress()
                    Toast.makeText(this@PostActivity, "Error: $e", Toast.LENGTH_SHORT).show()

                }

                override fun onComplete() {
                    hideProgress()
                }

            })
    }
    private fun hideProgress(){
        binding.progressBar.visibility = View.GONE
    }



}