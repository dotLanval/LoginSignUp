package will.com.data

import will.com.data.db.AppDatabase
import will.com.data.db.Users


class Repository(private val db: AppDatabase) {

    fun insertUser(user: Users) = db.userDao().userInfo(user)

    fun fetchUser(email: String, password: String) = db.userDao().fetchUser(email, password)

    fun fetchAllUsers(): List<Users> = db.userDao().fetchUser()
}