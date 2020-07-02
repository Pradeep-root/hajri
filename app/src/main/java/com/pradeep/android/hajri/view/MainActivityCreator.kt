package com.pradeep.android.hajri.view

import androidx.lifecycle.LiveData
import com.pradeep.android.hajri.model.Employee

interface MainActivityCreator {

    interface View {
        fun updateEmployeeList(employeeList : LiveData<List<Employee>>)
        fun error(msg : String)
    }

    interface Presenter {
        fun addHajri(employee : Employee)
        fun createEmployee(employee: Employee)
    }
}