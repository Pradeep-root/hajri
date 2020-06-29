package com.pradeep.android.hajri.model

import androidx.lifecycle.LiveData

interface HajriRepository {

    fun createEmployee(employee: Employee)
    fun addHajri(employee: Employee)
    fun showHajriListByDate(): LiveData<List<Employee>>
}