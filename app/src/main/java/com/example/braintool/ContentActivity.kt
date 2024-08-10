package com.example.braintool

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.braintool.databinding.ActivityContentBinding
import com.example.braintool.databinding.ActivityMainBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityContentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val item = intent.getStringExtra("toContent")
        Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()

    }
}