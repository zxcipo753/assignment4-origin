package edu.temple.assignment6fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider


private const val ARG_PARAM1 = "mangaDescription"
private const val ARG_PARAM2 = "mangaImage"

class SelectionFragment : Fragment() {
    private var param1: Array<String>? = null
    private var param2: IntArray? = null
    private lateinit var recycle: RecyclerView
    private lateinit var layout: View
    private lateinit var model: ImageModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getStringArray(ARG_PARAM1)
            param2 = it.getIntArray(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layout =  inflater.inflate(R.layout.fragment_selection2, container, false)
        return layout

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle = layout.findViewById<RecyclerView>(R.id.rcvFragView)
        model= ViewModelProvider(requireActivity()).get(ImageModel::class.java)
        val size = param1?.size
        Log.d("SIZE", size.toString())
        if (size != null) {
            val dogData = arrayOfNulls<ImageObject>(size)
            for (i in 0 until size) {
                dogData[i] = ImageObject(param1!![i],param2!![i])
            }
            val adapter = ImageAdapter(dogData)
            recycle.adapter = adapter
            adapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val dogD = (dogData[position]!!.description)
                    val dogI = (dogData[position]!!.resourceId)
                    model.dogDescription(dogD)
                    model.dogImage(dogI)
                }
            })
            recycle.layoutManager = GridLayoutManager(layout.context, 3)
        }

    }
    companion object {
        //factory method used
        fun newInstance(param1: Array<String>, param2: IntArray) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(ARG_PARAM1, param1)
                    putIntArray(ARG_PARAM2, param2)
                }
            }
    }
}


