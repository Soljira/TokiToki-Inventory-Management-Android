package com.example.tokitokiinventorymanagementandroid.models.dataclasses

import com.example.tokitokiinventorymanagementandroid.models.enums.UserRole
import com.google.firebase.Timestamp

data class User(
    val userID: String = "",  // should be the same as the UID in firebase auth
    val branchID: String? = null, // only for managers
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val role: UserRole = UserRole.NONE,
    val createdAt: Timestamp = Timestamp.now()
)
