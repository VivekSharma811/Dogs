package com.hypheno.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hypheno.dogs.model.DogBreed
import com.hypheno.dogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : BaseViewModel(application) {

    val dogBreed = MutableLiveData<DogBreed>()

    fun refresh(dogUuid : Int) {
       fetchFromDatabase(dogUuid)
    }

    private fun fetchFromDatabase(dogUuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(dogUuid)
            dogBreed.value = dog
        }
    }

}