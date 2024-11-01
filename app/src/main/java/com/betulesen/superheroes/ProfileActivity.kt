package com.betulesen.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.betulesen.superheroes.databinding.ActivityMainBinding
import com.betulesen.superheroes.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentFromAdapter = intent
        val selectHero = intentFromAdapter.getSerializableExtra("selectHero") as SuperHero

        binding.imageView.setImageResource(selectHero.gorsel)
        binding.nameTextView.text=selectHero.name
        binding.ageTextView.text= "Age : ${selectHero.age.toString()}"
        binding.descriptionTextView.text=selectHero.description
        binding.strengthsTextView.text=selectHero.strengths.joinToString(separator = ",")
        binding.weaknessesTextView.text=selectHero.weaknesses.joinToString (separator = ",")

    }

}