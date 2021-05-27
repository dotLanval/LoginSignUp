package will.com.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class Users (

    val username : String,

    @PrimaryKey
    @ColumnInfo(name = "userEmail")
    val email: String,

    val password: String
        )