package com.medialink.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.medialink.databinding.databinding.EmployeeItemBinding
import com.medialink.databinding.models.Employee

class EmployeeDataAdapter(val employees: ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeDataAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: EmployeeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val employeeItemBinding: EmployeeItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.employee_item,
            parent,
            false
        )
        return MyViewHolder(employeeItemBinding)
    }

    override fun getItemCount(): Int = employees.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val employee: Employee = employees[position]
        holder.binding.employee = employee
    }

    fun setEmployeeList(data: ArrayList<Employee>) {
        employees.clear()
        employees.addAll(data)
        notifyDataSetChanged()
    }
}