package latihan.android.com.latihan9.data

import android.app.Application
import android.arch.lifecycle.LiveData
import latihan.android.com.latihan9.data.data_model.People
import latihan.android.com.latihan9.data.data_net.PeopleListInfo
import latihan.android.com.latihan9.data.db_only.PeopleDAO
import latihan.android.com.latihan9.data.db_only.PeopleDb

class ContactRepo(application:Application) {

    private val peopleDao : PeopleDAO
    init {
        val peopleDatabase = PeopleDb.getInstance(application)
        peopleDao = peopleDatabase.peopleDao()
    }
    /**
     * menampilkan data tapi secara descending
     */
    fun getAllPeople(): LiveData<List<People>>{
//        val allpeople = PeopleListInfo.peopleList
//        return allpeople.reversed()
        return peopleDao.getAll()
    }
    fun insertPeople(people : People){
//        PeopleListInfo.peopleList.add(people)
        peopleDao.insert(people)
    }
    fun findPeople(id : Int):LiveData<People>{
//        for (people in PeopleListInfo.peopleList){
//            if(people.id== id){
//                return people
//            }
//        }
//        return null
        return peopleDao.find(id)
    }
}