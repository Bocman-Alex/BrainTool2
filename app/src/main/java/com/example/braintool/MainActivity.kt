package com.example.braintool
//        // Включаем ActionBar
//        supportActionBar?.setDisplayShowTitleEnabled(true)
//        supportActionBar?.title = "Название приложения"
// Установка цвета StatusBar
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

class MainActivity : AppCompatActivity() ,GroupAdapter.Listener{
    lateinit var binding: ActivityMainBinding
    private val adapter= GroupAdapter(this)
    private var editLaunncher:ActivityResultLauncher<Intent>? =null
    private var index = 0


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)





        window.statusBarColor = ContextCompat.getColor(this, R.color.likeBar)

        init()
        editLaunncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if (it.resultCode == RESULT_OK)
            {
                val f =it.data?.getStringExtra("group")
                val myObject = Group("$f")
                adapter.addGroup(myObject)
            }
        }
    }

    private  fun init() = with(binding)
    {
        apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity ,2)
            rcView.adapter = adapter
            addButton.setOnClickListener {
            editLaunncher?.launch(Intent(this@MainActivity,EditActivity::class.java))

            }
        }
    }

    override fun onClick(group: Group) {
       startActivity(Intent(this,ContentActivity::class.java).apply { putExtra("toContent",group.toString()) })
    }
}