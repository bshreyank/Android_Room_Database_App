package com.example.roomappstevdzasan.fragments.list

// Necessary imports for working with views, RecyclerView, and ViewBinding
import User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomappstevdzasan.R

// ListAdapter class that extends RecyclerView.Adapter to manage and display a list of users
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    // List to store the User objects to be displayed in the RecyclerView
    private var userList = emptyList<User>()

    // ViewHolder class that holds the views for each item in the RecyclerView
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    // Function to create and return a new ViewHolder object for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    // Function to bind the data to the ViewHolder for each item at a specific position
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Get the current User object based on the position
        val currentItem = userList[position]

        // Find the TextViews using findViewById and set(update) their text.
        holder.itemView.findViewById<TextView>(R.id.id_txt).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.firstName_txt).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.lastName_txt).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.age_txt).text = currentItem.age.toString()

        // Set the click listener for the row layout
        holder.itemView.findViewById<RecyclerView>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
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