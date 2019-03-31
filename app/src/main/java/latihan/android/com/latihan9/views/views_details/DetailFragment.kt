package latihan.android.com.latihan9.views.views_details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*
import latihan.android.com.latihan9.R
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People


class DetailFragment:Fragment()  {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id), 0)
        peopleId?.let {
            val peopleDetails = (activity?.application as StartApp).getPeopleRepo().findPeople(peopleId)
            populatePeopleDetails(peopleDetails)
        }
    }
    private fun populatePeopleDetails(people: People?){
        textViewName.text = people?.name
        textViewMet.text = people?.metAt
        buttonContact.text = people?.contact
        textInputEmail.text = people?.email
        textViewFb.text = people?.facebook
        textViewTw.text = people?.twitter


    }
}