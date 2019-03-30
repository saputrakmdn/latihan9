package latihan.android.com.latihan9

import android.app.Application
import latihan.android.com.latihan9.data.ContactRepo

class StartApp: Application() {
    fun getPeopleRepo()= ContactRepo(this)

}