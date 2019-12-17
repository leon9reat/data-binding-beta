package com.medialink.databinding.network

import com.medialink.databinding.models.EmployeeRespon
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeDataService {
    @GET("users/?per_page=12&amp;page=1")
    fun getEmployees(): Call<EmployeeRespon>
}