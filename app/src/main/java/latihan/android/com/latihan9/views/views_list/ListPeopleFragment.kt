package latihan.android.com.latihan9.views.views_list

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import latihan.android.com.latihan9.R
import latihan.android.com.latihan9.data.data_model.People

class ListPeopleFragment :Fragment(), ListPeopleAdapter.OnItemClickListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragmen_for_list_people, container, false)
    }
    override fun onItemClick(people: People, itemView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}