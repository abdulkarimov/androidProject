package com.example.abdulla.session4

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.abdulla.R
import java.util.*

class MenuActivity : AppCompatActivity() {
    private lateinit var notificationBuilder: NotificationBuilder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        notificationBuilder = NotificationBuilder(this)

    }
    val dateListener: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { datePicker, year: Int, month: Int, dayOfMonth: Int ->
            println("ACADEMY: year=$year month=$month day=$dayOfMonth")
        }
    val calendar = Calendar.getInstance()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuSetting -> {
                ShowMessage("setting")
                true
            }
            R.id.profile ->
            {
                DatePickerDialog(
                    this,
                    dateListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
                //showMessage("Profile")
                true

            }
            R.id.menu_file_create -> {
                notificationBuilder.showNotifivation("File", "Create")
                true
            }

            R.id.menu_file_open -> {
                val dialog = CustomDialog(this)
                dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }

    private fun ShowMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}