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
        this.title = resources.getString(R.string.selection_name)
        val mangaNames = resources.getStringArray(R.array.manga_names)
        val mangaImage: IntArray = intArrayOf(R.drawable.chihuahua,R.drawable.dashshund,
            R.drawable.doberman,R.drawable.goldenretriever,R.drawable.bulldog,R.drawable.pomeranian,
            R.drawable.havanese,R.drawable.corgi, R.drawable.bernesemountain,R.drawable.bodercollie,
            R.drawable.bodercollie,R.drawable.bodercollie)
        selectionFrag = SelectionFragment.newInstance(mangaNames,mangaImage)
        displayFrag = DisplayFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frgContainer1, selectionFrag)
            .add(R.id.frgContainer2,displayFrag)
            .commit()

    }
    private fun getData(): Array<ImageObject> {
        val mangaNames = resources.getStringArray(R.array.manga_names)
        return arrayOf(ImageObject(mangaNames[0], R.drawable.chihuahua), ImageObject(mangaNames[1].toString(),R.drawable.dashshund),
            ImageObject(mangaNames[2], R.drawable.doberman), ImageObject(mangaNames[3],R.drawable.goldenretriever),
            ImageObject(mangaNames[4],R.drawable.bulldog), ImageObject(mangaNames[5],R.drawable.pomeranian),
            ImageObject(mangaNames[6],R.drawable.havanese), ImageObject(mangaNames[7],R.drawable.corgi),
            ImageObject(mangaNames[8], R.drawable.bernesemountain), ImageObject(mangaNames[9],R.drawable.bodercollie),
            ImageObject(mangaNames[10], R.drawable.bernesemountain), ImageObject(mangaNames[11],R.drawable.bodercollie)
            )

    }
}
