package com.medialink.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.medialink.databinding.databinding.ActivityMainBinding
import com.medialink.databinding.models.Employee
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var employeeDataAdapter: EmployeeDataAdapter
    private var mList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        employeeDataAdapter = EmployeeDataAdapter(mList)

        rv_employee.setHasFixedSize(true)
        rv_employee.adapter = employeeDataAdapter

        mainViewModel.getAllEmployee().observe(this, Observer {
            if (!it.isEmpty()) employeeDataAdapter.setEmployeeList(it as ArrayList<Employee>)
        })
    }
}
