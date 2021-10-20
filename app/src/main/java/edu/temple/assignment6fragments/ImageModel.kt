package edu.temple.assignment6fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ImageModel: ViewModel() {
    val dogDescription: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun dogDescription(item:String){
        dogDescription.value=item
    }
    val dogImage: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    fun dogImage(item:Int){
        dogImage.value=item
    }
}