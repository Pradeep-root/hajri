package com.pradeep.android.hajri.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.android.hajri.R
import com.pradeep.android.hajri.inflate
import com.pradeep.android.hajri.model.Employee
import kotlinx.android.synthetic.main.item_hajari.view.*

class HajriAdapter(private val employeeList : ArrayList<Employee>) : RecyclerView.Adapter<HajriAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_hajari, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder?.tvEmployeeName.text = employeeList.get(position).fullName
       holder?.tvJobRole.text = employeeList.get(position).job
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvEmployeeName = itemView.txtEmployeeName
        val tvJobRole = itemView.txt_role
    }
}