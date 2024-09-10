package com.example.roomappstevdzasan.repository

import androidx.lifecycle.LiveData
import com.example.roomappstevdzasan.data.UserDao
import com.example.roomappstevdzasan.model.User

class UserRepository (private val userDao: UserDao){
    val readAllData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}

// Explanation of the code above ================================================================>>>>
/*
*
*This code defines a `UserRepository` class in Kotlin, which acts as a data manager for interacting with the app's data related to users.
* Here is a simplified explanation:

### Code Breakdown:

1. **Package Declaration**:
   - `package com.example.roomappstevdzasan.data`: This line indicates that the file is part of a package named `data` under `com.example.roomappstevdzasan`.

2. **LiveData Import**:
   - `import androidx.lifecycle.LiveData`: This line imports the `LiveData` class from Android's architecture components.
        `LiveData` is a lifecycle-aware observable data holder that allows the UI to automatically update when the data changes.

3. **UserRepository Class**:
   - `class UserRepository (private val userDao: UserDao)`: This defines a class named `UserRepository`.
   - It takes a parameter `userDao` of type `UserDao`. The `private` keyword means that this `userDao`
       instance can only be accessed within the `UserRepository` class.

4. **Property: readAllData**:
   - `val readAllData : LiveData<List<User>> = userDao.readAllData()`:
   - This line declares a read-only property (`val`) named `readAllData`.
   - `readAllData` holds a `LiveData` object that contains a list of `User` objects. It gets its value by calling the `readAllData()` function from `userDao`.
   - This property provides a way for other parts of the app to observe changes in the list of users and automatically update the UI.

5. **Function: addUser**:
   - `suspend fun addUser(user: User)`: This line defines a function named `addUser` that takes a parameter `user` of type `User`.
   - The `suspend` keyword means this function can be paused and resumed, allowing it to perform long-running operations like database
       transactions without blocking the main thread.
   - Inside the function, `userDao.addUser(user)` calls the `addUser` function of `userDao` to add a new user to the database.

### What Does This Code Do?

- **`UserRepository`** is a class that handles data operations related to users.
- It has a property, `readAllData`, which gives access to a live-updating list of all users stored in the database.
- It also has a function, `addUser`, that allows adding a new user to the database in a way that doesn't block the app's main thread.

### Why Use This Code?

- The repository pattern (`UserRepository`) is used to abstract the data access layer, making it easier to manage data from various sources
   (like a database or a network).
- It uses `LiveData` to ensure that the app's UI is always in sync with the latest data.
- The `suspend` keyword helps perform database operations in the background, preventing the app from freezing while waiting for the operation to complete.
*
* */