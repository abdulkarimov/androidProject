package com.example.abdulla.session7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.abdulla.R
import com.example.abdulla.session7.model.User
import com.example.abdulla.session7.model.Users
import com.example.abdulla.session7.retrofit.RetrofitClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class RxActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar : ProgressBar
    private var adapter: RecuclerAdapte = RecuclerAdapte()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)
        recyclerView = findViewById(R.id.recycler_view)
        progressBar = findViewById(R.id.progress_bar)

        findViewById<Button>(R.id.create_user_buttom).setOnClickListener()
        {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
            fetchUsers()

        }

    }
    private fun fetchUsers(){
        progressBar.visibility = View.VISIBLE
        RetrofitClient.getusers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Users>{
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onNext(t: Users) {
                    setUsers(t.data)
                }

                override fun onError(e: Throwable) {
                    hideProgress()
                    println(e)
                }

                override fun onComplete() {
                    hideProgress()

                }

            })
    }

    private fun hideProgress()
    {
            progressBar.visibility  = View.GONE

    }



    private fun setUsers(list: ArrayList<User>)
    {
        adapter.setData(list)

    }
}