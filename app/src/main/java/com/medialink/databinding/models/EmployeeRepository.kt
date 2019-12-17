package com.medialink.databinding.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.medialink.databinding.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository {
    private var employees: ArrayList<Employee> = arrayListOf()
    private var _employees: MutableLiveData<List<Employee>> = MutableLiveData(emptyList())

    fun getMutableLiveData(): MutableLiveData<List<Employee>> {
        val userDataService = RetrofitClient.getService()
        val call = userDataService.getEmployees()
        call.enqueue(object : Callback<EmployeeRespon> {
            override fun onFailure(call: Call<EmployeeRespon>, t: Throwable) {
                Log.d("debug", t.message.toString())
            }

            override fun onResponse(
                call: Call<EmployeeRespon>,
                response: Response<EmployeeRespon>
            ) {
                val employeeRespon = response.body()
                if (employeeRespon != null && employeeRespon.data != null) {
                    employees = employeeRespon.data as ArrayList<Employee>
                    _employees.value = employees
                }
            }

        })

        return _employees
    }
}