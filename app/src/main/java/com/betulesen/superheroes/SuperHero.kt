package com.betulesen.superheroes

import java.io.Serializable

class SuperHero(val name:String,
                val age:Int,
                val gorsel:Int,
                val description:String,
                val strengths: List<String>,
                val weaknesses: List<String> ) : Serializable{
}