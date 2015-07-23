package com.hannesdorfmann.sqlbrite.dao.sample.model.customer;

import com.hannesdorfmann.sqlbrite.dao.sample.model.Person;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

import java.util.Date;

/**
 * @author Hannes Dorfmann
 */
@ObjectMappable
public class Customer extends Person {

  public static final String TABLE_NAME = "Customer";
  public static final String COL_FIRSTNAME = "firstname";
  public static final String COL_LASTNAME = "lastname";
  public static final String COL_DATE = "date";
  public static final String COL_MEDIA = "media";

  private String firstname;
  private String lastname;
  private Date date;
  private byte[] media;

  public Customer() {
  }

  public Customer(long id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  @Column(COL_FIRSTNAME)
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  @Column(COL_LASTNAME)
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Date getDate() {
    return date;
  }

  @Column(COL_DATE)
  public void setDate(Date date) {
    this.date = date;
  }

  public byte[] getMedia() {
    return media;
  }

  @Column(COL_MEDIA)
  public void setMedia(byte[] media) {
    this.media = media;
  }
}
