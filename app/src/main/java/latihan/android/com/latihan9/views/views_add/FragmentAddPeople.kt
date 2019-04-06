package latihan.android.com.latihan9.views.views_add


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_people.*
import latihan.android.com.latihan9.R
import latihan.android.com.latihan9.StartApp
import latihan.android.com.latihan9.data.data_model.People

class FragmentAddPeople: android.support.v4.app.Fragment() {
    lateinit var btn_ : Button
    lateinit var viewModel: AddPeopleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddPeopleViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View = inflater.inflate(
            R.layout.fragment_add_people,
            container, false)
        btn_ = view.findViewById(R.id.btnsave)
        return view

    }
    private fun savePeopleInfo(){
        val people = People(
            textInputName.editText?.text.toString(),
            textInputMetAt.editText?.text.toString(),
            textInputContact.editText?.text.toString(),
            textInputEmail.editText?.text.toString(),
            textInputFb.editText?.text.toString(),
            textInputTw.editText?.text.toString()
        )
//        (activity?.application as StartApp).getPeopleRepo().insertPeople(people)
//        activity?.finish()
        viewModel.addPeople(people)
//        activity?.finish()
        Navigation.findNavController(view!!).navigateUp()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleInfo()
        }
    }

}