package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var nextBtn: Button
    lateinit var previousBtn: Button

    var currentIndex=0

    val images=arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)

    val titles=arrayOf(R.string.title1,R.string.title2,R.string.title3,R.string.title4)

    val descriptions=arrayOf( R.string.description1, R.string.description2, R.string.description2, R.string.description3)

    fun updateScreen() {
        imageView.setImageResource(images[currentIndex])
        title.setText(titles[currentIndex])
        description.setText(descriptions[currentIndex])
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageView=findViewById(R.id.image)
        title=findViewById(R.id.title)
        description=findViewById(R.id.description)
        nextBtn=findViewById(R.id.next_btn)
        previousBtn=findViewById(R.id.previous_btn)

       updateScreen()

        nextBtn.setOnClickListener {
            if(currentIndex<images.size-1){
                currentIndex++
                updateScreen()
            }
        }

        previousBtn.setOnClickListener {
            if(currentIndex>0){
                currentIndex--
                updateScreen()
            }
        }

    }
}