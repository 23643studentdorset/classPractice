package com.example.classpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.commit
import com.example.classpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        val rootView = binding.root
        setContentView(rootView)

        val helloWorld = findViewById<TextView>(R.id.helloWorld)
        Log.i("HelloWorld", helloWorld.text.toString())

        binding.helloWorld.text="Hello Android"

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.main_fragment, MainFragment().apply {
                arguments = Bundle().apply { putString("NEW_TEXT", "New Text") }
            })
        }
    }
}