package latihan.android.com.latihan9.data

import android.app.Application
import latihan.android.com.latihan9.data.data_model.People
import latihan.android.com.latihan9.data.data_net.PeopleListInfo

class ContactRepo(application:Application) {
    /**
     * menampilkan data tapi secara descending
     */
    fun getAllPeople(): List<People>{
        val allpeople = PeopleListInfo.peopleList
        return allpeople.reversed()
    }
    fun insertPeople(people : People){
        PeopleListInfo.peopleList.add(people)
    }
    fun findPeople(id : Int):People?{
        for (people in PeopleListInfo.peopleList){
            if(people.id== id){
                return people
            }
        }
        return null
    }
}