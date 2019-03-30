package latihan.android.com.latihan9.views.views_list

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragmen_for_list_people.*
import latihan.android.com.latihan9.R
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People

class ListPeopleFragment :Fragment(), ListPeopleAdapter.OnItemClickListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragmen_for_list_people, container, false)

    }
    override fun onItemClick(people: People, itemView: View) {
        Toast.makeText(activity.applicationContext, "test Click contact list", Toast.LENGTH_SHORT).show()
    }
    private fun populatePeopleList(peoplelist : List<People>){
        peopleRecyclerView.adapter = ListPeopleAdapter(peoplelist, this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener{
            Toast.makeText(activity.applicationContext, "test Click fab", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onResume() {
        super.onResume()
        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeople()
        populatePeopleList(people)
    }
}