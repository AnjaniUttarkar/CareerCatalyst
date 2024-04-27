package com.example.jobapp

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.HttpHeaders
import kotlinx.serialization.Serializable


class JobRepository {
    suspend fun getJobs(): List<Job> {
        val response = KtorClient.httpClient
            .get("https://findwork.dev/api/jobs/?format=json") {
                headers {
                    append(
                        HttpHeaders.Authorization,
                        "Token 60a6fdbaf908b774a8e0545b0af012673e2a651c"
                    )
                }
            }
            .body<JobResponse>()
        return response.results
    }

}

@Serializable
data class JobResponse(
    val count: Int = 0,
    val results: List<Job> = emptyList()
)