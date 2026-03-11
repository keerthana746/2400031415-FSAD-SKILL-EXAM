package com.klef.fsad.RestaurantHQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klef.fsad.exam.Restaurant;

public class Client
{
 public static void main(String[] args)
 {
  Configuration cfg = new Configuration();
  cfg.configure("hibernate.cfg.xml");

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();

  // INSERT
  Transaction tx = session.beginTransaction();

  Restaurant r = new Restaurant();
  r.setId(102);
  r.setName("Dominos");
  r.setLocation("Vijayawada");

  session.save(r);

  tx.commit();
  System.out.println("Record Inserted");

  // UPDATE
  Transaction tx2 = session.beginTransaction();

  Restaurant r1 = session.get(Restaurant.class,102);

  r1.setName("Pizza Hut");
  r1.setLocation("Hyderabad");

  session.update(r1);

  tx2.commit();
  System.out.println("Record Updated");

  session.close();
  sf.close();
 }
}