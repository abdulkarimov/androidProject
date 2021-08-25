package com.example.abdulla.session5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abdulla.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)



      //  supportFragmentManager
      //      .beginTransaction()
      //      .add(R.id.Frame_layout, StartFragment.newInstance("text1","text2"))
      //      .commit()
    }
 fun onNext(){
   //supportFragmentManager
   //    .beginTransaction()
   //    .add(R.id.Frame_layout,finishFragment.newInstance("text3","text4"))
   //    .commit()
}

}