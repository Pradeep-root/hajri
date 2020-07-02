package com.pradeep.android.hajri.model

data class Employee(
    val firstName: String,
    val lastName: String,
    val job: String,
    val rate: Double,
    val hajriList : List<Hajri>
)
