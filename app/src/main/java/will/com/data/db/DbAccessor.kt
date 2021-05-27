package will.com.data.db

import androidx.room.Room

object DbAccessor {
    val db =
        Room.databaseBuilder(MainApplication.applicationContext(), AppDatabase::class.java, "user-database")
            .allowMainThreadQueries()
            .build()
}

