package latihan.android.com.latihan9.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People

class AddPeopleViewModel(application: Application) : AndroidViewModel(application) {
    private val peopleRepository = getApplication<StartApp>().getPeopleRepo()
    fun addPeople(people: People){
        peopleRepository.insertPeople(people)
    }
}