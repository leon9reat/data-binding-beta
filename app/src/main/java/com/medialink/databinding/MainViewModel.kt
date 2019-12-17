package com.medialink.databinding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.medialink.databinding.models.Employee
import com.medialink.databinding.models.EmployeeRepository

class MainViewModel : ViewModel() {
    private var employeeRepository: EmployeeRepository

    init {
        employeeRepository = EmployeeRepository()
    }

    fun getAllEmployee(): LiveData<List<Employee>> {
        return employeeRepository.getMutableLiveData()
    }
}