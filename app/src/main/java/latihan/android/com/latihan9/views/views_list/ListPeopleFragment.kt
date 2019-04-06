package latihan.android.com.latihan9.views.views_list


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragmen_for_list_people.*
import latihan.android.com.latihan9.R
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People
import latihan.android.com.latihan9.views.views_add.AddPeopleData
import latihan.android.com.latihan9.views.views_details.DetailAct

class ListPeopleFragment :Fragment(), ListPeopleAdapter.OnItemClickListener{
    private lateinit var viewModel : PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragmen_for_list_people, container, false)

    }
    override fun onItemClick(people: People, itemView: View) {
//        Toast.makeText(context, "test Click contact list", Toast.LENGTH_SHORT).show()
//        val intent = Intent(context, DetailAct::class.java)
//        intent.putExtra(getString(R.string.people_id), people.id)
//        startActivity(intent)
        val detailBundle = Bundle().apply {
            putInt("PEOPLE_ID", people.id)
        }
        view?.findNavController()?.navigate(R.id.action_listPeopleFragment_to_detailFragment, detailBundle)
    }
    private fun populatePeopleList(peoplelist : List<People>){
        peopleRecyclerView.adapter = ListPeopleAdapter(peoplelist, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener{
//            Toast.makeText(context, "test Click fab", Toast.LENGTH_SHORT).show()
//            val intent = Intent(context, AddPeopleData::class.java)
//            startActivity(intent)
            view.findNavController().navigate(R.id.action_listPeopleFragment_to_fragmentAddPeople)
        }
         viewModel.getPeopleList().observe(this, Observer<List<People>> {
             peoples -> peoples?.let {
             populatePeopleList(peoples)
         }
         })
    }
//    override fun onResume() {
//        super.onResume()
////        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeople()
////        populatePeopleList(people)
//
//        val peopleRepo = (activity?.application as StartApp).getPeopleRepo()
//        peopleRepo.getAllPeople().observe(this, Observer {
//            peopleList -> populatePeopleList(peopleList!!)
//        })
//    }
}