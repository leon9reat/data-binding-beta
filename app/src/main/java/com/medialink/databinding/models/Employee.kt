package com.medialink.databinding.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.gson.annotations.SerializedName
import com.medialink.databinding.R

data class Employee(

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null

) {

}

@BindingAdapter( "avatar" )
fun loadImage(imageView: ImageView, imageUrl: String) {
	Glide.with(imageView.context)
		.load(imageUrl)
		.transform(CircleCrop())
		.placeholder(R.drawable.loading)
		.into(imageView)
}