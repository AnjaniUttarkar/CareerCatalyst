package com.example.jobapp
import kotlinx.serialization.Serializable

@Serializable
data class Job (
    val id: String ="",
    val role:String ="",
    val company_name:String="",
    val logo:String?="",
    val url:String=""

)