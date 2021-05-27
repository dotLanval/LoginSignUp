package will.com.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    //lets user input information into database = action: inserting data
    @Insert fun userInfo(vararg users: Users)

    //Grabs user information based on email = action: retrieving data
    @Query("SELECT * FROM userTable WHERE userEmail =:email and password =:password")
    fun fetchUser(email: String, password: String): Users

    @Query("Select * from  userTable")
    fun fetchUser(): List<Users>


}

