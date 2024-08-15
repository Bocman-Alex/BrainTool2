package com.example.braintool

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.braintool.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private val adapter = QuestionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        initButtons()
    }

    private fun  initButtons() = with(binding){
        bDone.setOnClickListener{
            val group = binding.edGroupTitle.text.toString()
            val editIntent = Intent().apply {
                putExtra("group", group)
            }
            setResult(RESULT_OK ,editIntent)
            finish()
        }
        rcViewEA.layoutManager=LinearLayoutManager(this@EditActivity)
        rcViewEA.adapter=adapter
        addQueButton.setOnClickListener {
            val question=Question("Че тапаешь?","f")
            adapter.addQuestion(question)
        }
    }
}