package latihan.android.com.latihan9.views.views_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People

class PeopleDetailsViewModel(application: Application): AndroidViewModel(application){
    private val peopleRepository = getApplication<StartApp>().getPeopleRepo()
    private val peopleId = MutableLiveData<Int>()

    fun getPeopleDetails(id: Int): LiveData<People>{
        peopleId.value = id
        val peopleDetails = Transformations.switchMap<Int, People>(peopleId){id ->
            peopleRepository.findPeople(id)
        }
        return  peopleDetails
    }
}