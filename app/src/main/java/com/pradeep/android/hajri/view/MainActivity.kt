package com.pradeep.android.hajri.view

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pradeep.android.hajri.R
import com.pradeep.android.hajri.adapters.HajriAdapter
import com.pradeep.android.hajri.firebase.FirebaseDatabaseManager
import com.pradeep.android.hajri.model.Employee
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_employee_dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var hajriAdapter: HajriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        recycler_view.layoutManager = LinearLayoutManager(this)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            createEmployeeDialog()
        }

        FirebaseDatabaseManager().getListOfHajri()?.observe(this, Observer {
            hajriAdapter = HajriAdapter(it)
            recycler_view.adapter = hajriAdapter
            hajriAdapter.notifyDataSetChanged()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun createEmployeeDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = inflater.inflate(R.layout.add_employee_dialog, null, false)
        builder.setView(customView)
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

        customView.addEmployee.setOnClickListener{
            FirebaseDatabaseManager().createEmployee(Employee(customView.txtFullName.text.toString(),
                customView.txtRole.text.toString(), customView.txtRate.text.toString().toDouble()))
            alertDialog.dismiss()
        }

        customView.cancel.setOnClickListener (){
            alertDialog.dismiss()
        }
    }
}