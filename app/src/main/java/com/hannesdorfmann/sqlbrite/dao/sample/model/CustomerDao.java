package com.hannesdorfmann.sqlbrite.dao.sample.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.hannesdorfmann.sqlbrite.dao.Dao;
import com.hannesdorfmann.sqlbrite.dao.sample.model.customer.Customer;
import com.hannesdorfmann.sqlbrite.dao.sample.model.customer.CustomerMapper;
import com.squareup.sqlbrite.SqlBrite;

import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author Hannes Dorfmann
 */
public class CustomerDao extends Dao {

  @Override public void createTable(SQLiteDatabase database) {

    CREATE_TABLE(Customer.TABLE_NAME,
        Customer.COL_ID + " INTEGER PRIMARY KEY NOT NULL",
        Customer.COL_FIRSTNAME + " TEXT",
        Customer.COL_LASTNAME + " TEXT",
        Customer.COL_DATE + " INT",
        Customer.COL_MEDIA + " BLOB")
        .execute(database);

  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  public Observable<List<Customer>> getCustomers() {
    return query(SELECT(Customer.COL_ID, Customer.COL_FIRSTNAME, Customer.COL_LASTNAME, Customer.COL_DATE).FROM(
        Customer.TABLE_NAME)).map(new Func1<SqlBrite.Query, List<Customer>>() {
      @Override public List<Customer> call(SqlBrite.Query query) {

        return CustomerMapper.list(query.run());
      }
    });
  }

  public Observable<Long> insert(int id, String firstname, String lastname, Date date) {
    ContentValues values =
        CustomerMapper
                .contentValues()
                .id(id)
                .firstname(firstname)
                .lastname(lastname)
                .setDate(date)
                .build();

    return insert(Customer.TABLE_NAME, values);
  }
}