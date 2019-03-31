package latihan.android.com.latihan9.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People

class PeopleListViewModel (application: Application) : AndroidViewModel(application) {
    private val peopleRepo = getApplication<StartApp>().getPeopleRepo()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>>{
        return peopleList
    }
    fun getAllPeople(){
        peopleList.addSource(peopleRepo.getAllPeople()){
            peoples -> peopleList.postValue(peoples)
        }
    }
}