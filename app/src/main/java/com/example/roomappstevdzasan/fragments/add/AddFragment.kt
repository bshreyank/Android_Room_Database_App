package com.example.roomappstevdzasan.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomappstevdzasan.R
import com.example.roomappstevdzasan.data.User
import com.example.roomappstevdzasan.data.UserViewModel

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private lateinit var addFirstNameEt: EditText
    private lateinit var addLastNameEt: EditText
    private lateinit var addAgeEt: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Find views by their IDs
        addFirstNameEt = view.findViewById(R.id.addFirstName_et)
        addLastNameEt = view.findViewById(R.id.addLastName_et)
        addAgeEt = view.findViewById(R.id.addAge_et)

//        view.add_btn.setOnClickListener{
//            insertDataToDatabase()
//        }

        val addButton = view.findViewById<Button>(R.id.add_btn)

        addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase(){
        val firstName = addFirstNameEt.text.toString()
        val lastName = addLastNameEt.text.toString()
        val age = addAgeEt.text

        if(inputCheck(firstName,lastName,age)){
            // Create User Object
            val user = User(0,firstName, lastName, Integer.parseInt(age.toString()))

            // Add Data to Database'
            mUserViewModel.addUser(user)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all the fields.", Toast.LENGTH_LONG).show()
        }
    }

    // This function will check if the fields from insertDataToDatabase() are empty or not?
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return!(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}