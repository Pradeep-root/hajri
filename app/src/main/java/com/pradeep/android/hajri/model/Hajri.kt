package com.pradeep.android.hajri.model

class Hajri(
    val timeStamp:  Long = System.currentTimeMillis(),
    val status: Int,
    val rate: Int
)