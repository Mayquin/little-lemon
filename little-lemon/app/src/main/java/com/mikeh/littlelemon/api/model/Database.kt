package com.mikeh.littlelemon.api.model

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

/**
 * Created by Maycon Henrique on 27/01/2025.
 * maycon255@hotmail.com
 */

@Entity(tableName = "MenuItemRoom")
data class MenuItemRoom(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    @ColumnInfo(name = "category")
    val category: String,
)

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Query("SELECT DISTINCT category FROM MenuItemRoom")
    fun getDistinctCategories(): LiveData<List<String>>

    @Query("SELECT * FROM MenuItemRoom WHERE category = :category")
    fun getItemsCategory(category: String): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menuItems: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}
