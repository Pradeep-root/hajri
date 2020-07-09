package com.pradeep.android.hajri.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.pradeep.android.hajri.model.Employee

class FirebaseDatabaseManager( private val firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()) {

    private val employeeListLiveData = MutableLiveData<ArrayList<Employee>>()

    fun createEmployee(employee : Employee){
        firebaseDatabase.reference.child("Employees").push().setValue(employee)
    }

    fun updateHajri(){
        //TODO update hajri
    }

    fun getListOfHajri() : LiveData<ArrayList<Employee>>?{
        firebaseDatabase.reference.child("Employees").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                Log.i("onCancelled", p0.toString())
            }

            override fun onDataChange(p0: DataSnapshot?) {
                val employeeList = arrayListOf<Employee>()
                p0!!.children.forEach {
                    employeeList.add(it.getValue(Employee::class.java) as Employee)
                }
                employeeListLiveData.postValue(employeeList)
            }
        })
        return employeeListLiveData
    }
}