package com.example.braintool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.braintool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter= GroupAdapter()
    private var editLaunncher:ActivityResultLauncher<Intent>? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
//        // Включаем ActionBar
//        supportActionBar?.setDisplayShowTitleEnabled(true)
//        supportActionBar?.title = "Название приложения"
        // Установка цвета StatusBar
        window.statusBarColor = ContextCompat.getColor(this, R.color.likeBar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        init()

        editLaunncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            if (it.resultCode == RESULT_OK)
            {

                val f = intent.getParcelableExtra("group", Group::class.java)
                Log.d("logDebug", "приняl зн из ЕдА  ===  $f ")

                if (f != null) {
                    Log.d("logDebug", "закинул зн в ерр == $f")
                    binding.err.text= f.toString()
                    Log.d("logDebug", "закинул зн в адаптер == $f")
                    adapter.addGroup(f)
                }
            }
        }
    }



    private  fun init() = with(binding){
        apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity ,2)
            rcView.adapter = adapter



            addButton.setOnClickListener {
editLaunncher?.launch(Intent(this@MainActivity,EditActivity::class.java))
                Log.d("logDebug", "Запущен едит активити")
             //   Toast.makeText(this@MainActivity, "a", Toast.LENGTH_SHORT).show()
//                if (index>4)index=0
//                val group =Group("Group №$index")
//                adapter.addGroup(group)
//                index++

            }
        }
    }
}