package com.example.roomappstevdzasan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomappstevdzasan.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
    }
    }
}

// Explanation of the code above ================================================================>>>>

/*
*
* Sure! Let's break down this code step-by-step to make it easy to understand.

### Code Breakdown:

1. **Package Declaration**:
   - `package com.example.roomappstevdzasan.data`: This line specifies that the code is part of a package called `data` under `com.example.roomappstevdzasan`.

2. **Imports**:
   - The code imports classes from the Android framework needed to set up a Room database:
     - `android.content.Context`: Provides access to application-specific resources and classes.
     - `androidx.room.Database`, `Room`, and `RoomDatabase`: These are from the Room library,
          which is an SQLite object-mapping library that provides an abstraction layer over SQLite for easier database management.

3. **Annotation: `@Database`**:
   - `@Database(entities = [User::class], version = 1, exportSchema = false)`:
   - This annotation tells Room that this is a database class. It has:
     - `entities`: A list of tables in this database. Here, `[User::class]` means there is one table called `User`.
     - `version = 1`: The version of the database schema. This is the initial version.
     - `exportSchema = false`: Indicates whether or not to export the database schema for version management. Here it is set to `false`.

4. **Abstract Class: `UserDatabase`**:
   - `abstract class UserDatabase : RoomDatabase()`: This defines an abstract class named `UserDatabase` that extends `RoomDatabase`.
   - It represents the database for your app. Room will automatically generate the necessary code to create and manage the database.

5. **Abstract Function: `userDao()`**:
   - `abstract fun userDao(): UserDao`: This function is an abstract method that returns a `UserDao` instance.
        The `UserDao` provides the methods to access the database (like adding or reading users).

6. **Companion Object**:
   - `companion object { ... }`: A companion object is similar to a static method in Java.
        It allows us to create or manage a single instance of the `UserDatabase` throughout the app (this is known as a singleton pattern).

7. **Volatile Instance**:
   - `@Volatile private var INSTANCE: UserDatabase? = null`:
   - The `INSTANCE` variable is marked with `@Volatile` to make sure that the instance is always up-to-date and visible to all threads.
           This prevents multiple instances from being created when accessed from different threads.

8. **`getDatabase` Function**:
   - `fun getDatabase(context: Context): UserDatabase { ... }`: This function is used to get the single (singleton) instance of the `UserDatabase`.
   - **Inside `getDatabase`**:
     - `val tempInstance = INSTANCE`: Temporarily stores the current instance of `UserDatabase`.
     - `if(tempInstance != null)`: Checks if an instance already exists; if it does, it returns that existing instance.
     - `synchronized(this) { ... }`: If no instance exists (`tempInstance` is `null`),
              it synchronizes this block to make sure only one thread can access it at a time.
       - `Room.databaseBuilder(...)`: This creates a new instance of the `UserDatabase` using Room’s `databaseBuilder` method:
         - `context.applicationContext`: Provides the application context to avoid memory leaks.
         - `UserDatabase::class.java`: The class type of the database.
         - `"user_database"`: The name of the database file.
       - `INSTANCE = instance`: Saves the newly created instance for future use.
       - `return instance`: Returns the new or existing instance of `UserDatabase`.

### What Does This Code Do?

- This code sets up a **Room database** for the app.
- It defines a `UserDatabase` class, which is the main access point to the app's persisted data.
- It uses a **singleton pattern** to ensure that only one instance of the database is created throughout the app's lifecycle.
      This is done to avoid unnecessary resources being consumed by creating multiple database instances.
- The `getDatabase` function provides a way to get the single instance of the database,
      either by returning an existing one or creating a new one if it does not exist.

### Why Use This Code?

- **Database Setup**: The code sets up a Room database, which provides a modern, easy-to-use abstraction layer over SQLite.
- **Efficient Memory Usage**: The singleton pattern ensures that only one database instance is used throughout the app, reducing memory consumption.
- **Thread Safety**: The `synchronized` block and `@Volatile` keyword ensure thread-safe access to the database,
       preventing potential issues with concurrent database access.

By using this code, you can easily create and manage a local database in your Android app, efficiently handling data storage and retrieval.
* */