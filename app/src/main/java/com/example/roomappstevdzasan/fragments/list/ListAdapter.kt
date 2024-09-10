package com.example.roomappstevdzasan.fragments.list

// Necessary imports for working with views, RecyclerView, and ViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomappstevdzasan.data.User
import com.example.roomappstevdzasan.databinding.CustomRowBinding

// ListAdapter class that extends RecyclerView.Adapter to manage and display a list of users
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    // List to store the User objects to be displayed in the RecyclerView
    private var userList = emptyList<User>()

    // ViewHolder class that holds the views for each item in the RecyclerView
    class MyViewHolder(private val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root) {
        // Bind data from a User object to the views in the layout
        fun bind(user: User) {
            // Set text for each TextView using the data from the User object
            binding.idTxt.text = user.id.toString()          // Display user ID
            binding.firstNameTxt.text = user.firstName       // Display user first name
            binding.lastNameTxt.text = user.lastName         // Display user last name
            binding.ageTxt.text = user.age.toString()        // Display user age
        }
    }

    // Function to create and return a new ViewHolder object for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each row (custom_row.xml) and create a binding object
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Return a new ViewHolder that contains the inflated layout
        return MyViewHolder(binding)
    }

    // Function to bind the data to the ViewHolder for each item at a specific position
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Get the current User object based on the position
        val currentItem = userList[position]
        // Call the bind function to set the data to the views
        holder.bind(currentItem)
    }

    // Function that returns the total number of items in the list
    override fun getItemCount(): Int {
        return userList.size // Return the size of the userList
    }

    // Function to update the data in the adapter and refresh the RecyclerView
    fun setData(users: List<User>) {
        this.userList = users  // Update the userList with the new data
        notifyDataSetChanged() // Notify the adapter that the data has changed, so it refreshes the view
    }
}

/*
*

Explanation of Key Parts:
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>():
Defines a ListAdapter class that inherits from RecyclerView.Adapter,
    which requires implementing three key functions: onCreateViewHolder, onBindViewHolder, and getItemCount.

private var userList = emptyList<User>():
Initializes an empty list to store the user data.
    This list is later filled with actual data using the setData() function.

class MyViewHolder:
Represents a single row in the RecyclerView.
    It holds the views for each item (row) in the list.
    The constructor takes a CustomRowBinding object,
    which provides references to the views in the custom_row.xml layout file.

onCreateViewHolder:
Inflates the custom_row.xml layout using CustomRowBinding.
    It creates a new MyViewHolder instance for each item in the RecyclerView.

onBindViewHolder:
Binds the data to the views for each item at a specific position in the list.
    It retrieves the current user from userList based on the position and calls the bind() function to set the data.

getItemCount:
Returns the number of items in the userList,
    which tells the RecyclerView how many items it needs to display.

setData:
Updates the list of users in the adapter and refreshes the RecyclerView to display the updated data.

This version should make it clear what each part of the code does,
    providing a straightforward and easy-to-understand implementation of a RecyclerView adapter using modern practices.

* */