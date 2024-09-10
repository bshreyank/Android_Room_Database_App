package com.example.roomappstevdzasan.fragments.update

import User
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomappstevdzasan.R
import com.example.roomappstevdzasan.viewmodel.UserViewModel


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        // Initialize View Model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel:: class.java)

        view.findViewById<TextView>(R.id.updateFirstName_et).setText(args.currentUser.firstName)
        view.findViewById<TextView>(R.id.updateLastName_et).setText(args.currentUser.lastName)
        view.findViewById<TextView>(R.id.updateAge_et).setText(args.currentUser.age.toString())

        view.findViewById<Button>(R.id.update_btn).setOnClickListener{
            updateItem()
        }

        return view
    }

    private fun updateItem(){
//        val firstName = updateFirstName_et.text.toString()
//        val lastName = updateLastName_et.text.toString()
//        val age = Integer.parseInt(updateAge_et.text.toString())

        // Access the views directly inside the function
        val firstName = requireView().findViewById<EditText>(R.id.updateFirstName_et).text.toString()
        val lastName = requireView().findViewById<EditText>(R.id.updateLastName_et).text.toString()
        val age = Integer.parseInt(requireView().findViewById<EditText>(R.id.updateAge_et).text.toString())


        if(inputCheck(firstName, lastName, requireView().findViewById<EditText>(R.id.updateAge_et).text)){
            //Create User object
            val updatedUser = User(args.currentUser.id, firstName,lastName, age)

            // Update Current User.
            // Here we are going to use a ViewModel to call our update function for room database.
            // The update query from room database will run here with the help of viewmodel.
            mUserViewModel.updateUser(updatedUser)

            //Display success toast message
            Toast.makeText(requireContext(),"Updated successfully", Toast.LENGTH_SHORT).show()

            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields", Toast.LENGTH_SHORT).show()
        }

    }

    // This function will check if the fields from insertDataToDatabase() are empty or not?
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return!(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}

/*
*
** requireView() **
 is a function in the Android Fragment class that provides
 a reference to the root view of the fragment's layout.
 It is used to access views within the fragment's layout after it has been created.
*
*/