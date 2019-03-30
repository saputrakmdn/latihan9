package latihan.android.com.latihan9.data.data_net

import latihan.android.com.latihan9.data.data_model.People

class PeopleListInfo {
    companion object {
        var peopleList = initPeopleList()

        /**
         * add dummy data
         */

        private  fun initPeopleList() : MutableList<People>{
            var po_peoples = mutableListOf<People>()
            po_peoples.add(People(
                "Saputra",
                "Tangerang",
                "089484",
                "saputra.kmdn@gmail.com",
                "fb.me/saputra",
                "twitter.com/saputra_kmdn",
                1

            ))
            po_peoples.add(People(
                "Saputra",
                "Tangerang",
                "089484",
                "saputra.kmdn@gmail.com",
                "fb.me/saputra",
                "twitter.com/saputra_kmdn",
                2
            ))
            po_peoples.add(People(
                "Saputra",
                "Tangerang",
                "089484",
                "saputra.kmdn@gmail.com",
                "fb.me/saputra",
                "twitter.com/saputra_kmdn",
                3
            ))
            return po_peoples
        }
    }
}