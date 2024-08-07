package com.example.braintool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.braintool.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
      //  }
binding.bDone.setOnClickListener{

    initButtons()

}
    }


    private fun  initButtons() = with(binding){
            val group =   Group(edGroupTitle.text.toString())
        Log.d("logDebug", "Получено зн из edGroupTitle = $group ")
            val editIntent = Intent(this@EditActivity,MainActivity::class.java)
        Log.d("logDebug", "передает зн из ЕдА === $group")
                editIntent.putExtra("group", group)

            //     startActivity(editIntent)
               setResult(RESULT_OK ,editIntent)
                finish()
        }
    }

