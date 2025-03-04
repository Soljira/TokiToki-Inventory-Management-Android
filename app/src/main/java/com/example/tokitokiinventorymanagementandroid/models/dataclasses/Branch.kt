package com.example.tokitokiinventorymanagementandroid.models.dataclasses

data class Branch(
    val branchID: String = "",
    val name: String = "",
    val location: String = "",
    val managers: List<String> = listOf()
)
