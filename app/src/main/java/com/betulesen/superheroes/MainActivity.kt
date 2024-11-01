package com.betulesen.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulesen.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var superHeroList : ArrayList<SuperHero>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superman = SuperHero("Superman",30,R.drawable.superman,"A hero from the planet Krypton.",
            listOf("Fly", "Super strength", "Fast recovery"),listOf("Kryptonite", "Vulnerability to magic")
        )
        val batman = SuperHero("Batman",35,R.drawable.batman,"A vigilante from Gotham City who fights crime with intelligence and technology.",
            listOf("Exceptional intelligence", "Master martial artist", "Access to advanced technology"),listOf("Psychological trauma", "Dependence on gadgets")
        )
        val ironman = SuperHero("Ironman",40,R.drawable.ironman,"A wealthy industrialist and engineer who fights crime using his advanced armored suit.",
            listOf("Exceptional intelligence", "Advanced technology", "Superpowers from the suit"),listOf("Mortal (not superhuman)", "Emotional vulnerabilities")
        )
        val aquaman = SuperHero("Aquaman",35,R.drawable.aquaman,"The ruler of Atlantis and a hero who can communicate with marine life and control water.",
            listOf("Superhuman strength", "Ability to communicate with sea creatures", "Master of underwater combat"),listOf("Vulnerable to dehydration", "Struggles with land-dwelling politics")
        )


        superHeroList= arrayListOf(superman,batman,ironman,aquaman)

        val adapter = SuperHolderAdapter(superHeroList)
        binding.superHeroRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.superHeroRecyclerView.adapter=adapter



    }
}