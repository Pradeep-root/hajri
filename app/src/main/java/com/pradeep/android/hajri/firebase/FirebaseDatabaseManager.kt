package com.pradeep.android.hajri.firebase

import com.google.firebase.database.FirebaseDatabase
import com.pradeep.android.hajri.model.Employee

class FirebaseDatabaseManager( private val firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()) {

    fun createEmployee(employees : List<Employee>){
        firebaseDatabase.reference.child("Employees").setValue(employees)
    }
}