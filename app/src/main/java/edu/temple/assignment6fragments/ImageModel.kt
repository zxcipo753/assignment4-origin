package edu.temple.assignment6fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ImageModel: ViewModel() {
    val mangaDescription: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun mangaDescription(item:String){
        mangaDescription.value=item
    }
    val mangaImage: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    fun mangaImage(item:Int){
        mangaImage.value=item
    }
}