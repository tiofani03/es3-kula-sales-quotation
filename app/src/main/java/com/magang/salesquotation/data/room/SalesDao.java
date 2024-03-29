package com.magang.salesquotation.data.room;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.magang.salesquotation.data.entity.Sales;

import java.util.List;

//Interface agar mudah terhubung ke setiap viewmodel
@Dao
public interface SalesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Sales sales);

    @Update
    void update(Sales sales);

    @Delete
    void delete(Sales sales);

    @RawQuery(observedEntities = Sales.class)
    DataSource.Factory<Integer, Sales> getAllSales(SupportSQLiteQuery query);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Sales> list);

    @Query("SELECT * FROM Sales WHERE itemName LIKE '%' || :search || '%'")
    DataSource.Factory<Integer,Sales> getSearchData(String search);
}
