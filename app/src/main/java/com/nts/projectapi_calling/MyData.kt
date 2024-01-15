package com.nts.projectapi_calling

data class MyData(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)