package com.phillip.kmm2

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import java.net.InetSocketAddress
import java.net.Proxy
import javax.security.auth.callback.Callback


const val localHostServerPort = 8888
class ApiServer {

    private val httpClient: HttpClient = HttpClient(Android) {
        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
            //proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("localhost", localHostServerPort))
        }
    }


    suspend fun connectToGoogle(callback: (HttpResponse) -> Unit) {
        val response = httpClient.request<HttpResponse> {
            url("www.google.com")
            method = HttpMethod.Get
        }

        if(response.status == HttpStatusCode.OK) {
            callback(response)
        }
    }

}