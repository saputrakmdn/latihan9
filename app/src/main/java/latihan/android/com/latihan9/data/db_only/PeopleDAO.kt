package latihan.android.com.latihan9.data.db_only

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import latihan.android.com.latihan9.data.data_model.People


@Dao
interface PeopleDAO {
    //query select
    @Query("select * from people order by id desc")
    fun getAll() : List<People>

    //query insert
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insert(people: People)

    //query delete
    @Query ("delete from people")
    fun  deleteAll()

    //query select by id
    @Query("select *from people where id = :id")
    fun find (id : Int): People
}