package com.juancho1037.umadefoods.ui.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juancho1037.umadefoods.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
	private lateinit var startBinding: ActivityStartBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		startBinding = ActivityStartBinding.inflate(layoutInflater)
		setContentView(startBinding.root)
		
		supportActionBar?.hide()
	}
}