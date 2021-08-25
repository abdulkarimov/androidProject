package com.example.abdulla
import com.example.abdulla.RecyclerAdapter.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycelerViewActivity : AppCompatActivity() {
    val recyclerList : ArrayList<Item> = arrayListOf(Item("Item 1",R.drawable.ic__phenix),Item("Item 2" , R.drawable.s))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyceler_view)


        setRecyclerView()

    }

    private fun setRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter()
        adapter.setData(recyclerList)
        recyclerView.adapter = adapter
    }
}