package edu.temple.assignment6fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import java.util.EnumSet.of
import java.util.List.of

class MainActivity : AppCompatActivity() {
    private lateinit var selectionFrag: SelectionFragment
    private lateinit var displayFrag: DisplayFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = "Dogs gallery"

        val dogName = resources.getStringArray(R.array.manga_names)
        val dogImage: IntArray = intArrayOf(R.drawable.chihuahua,R.drawable.dashshund,
            R.drawable.doberman,R.drawable.goldenretriever,R.drawable.bulldog,R.drawable.pomeranian,
            R.drawable.havanese,R.drawable.corgi, R.drawable.bernesemountain,R.drawable.bodercollie,
            R.drawable.bodercollie,R.drawable.bodercollie)
        selectionFrag = SelectionFragment.newInstance(dogName,dogImage)
        displayFrag = DisplayFragment()
        supportFragmentManager.beginTransaction() //transaction used here
            .add(R.id.frgContainer1, selectionFrag)
            .add(R.id.frgContainer2,displayFrag)
            .commit()

    }
    private fun getData(): Array<ImageObject> {
        val dogNames = resources.getStringArray(R.array.manga_names)
        return arrayOf(ImageObject(dogNames[0], R.drawable.chihuahua), ImageObject(dogNames[1].toString(),R.drawable.dashshund),
            ImageObject(dogNames[2], R.drawable.doberman), ImageObject(dogNames[3],R.drawable.goldenretriever),
            ImageObject(dogNames[4],R.drawable.bulldog), ImageObject(dogNames[5],R.drawable.pomeranian),
            ImageObject(dogNames[6],R.drawable.havanese), ImageObject(dogNames[7],R.drawable.corgi),
            ImageObject(dogNames[8], R.drawable.bernesemountain), ImageObject(dogNames[9],R.drawable.bodercollie),
            ImageObject(dogNames[10], R.drawable.bernesemountain), ImageObject(dogNames[11],R.drawable.bodercollie)
            )

    }
}
