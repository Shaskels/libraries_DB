package main.query;

import main.entity.LibraryCard;
import main.entity.User;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class UserQuery {
//    Session session;
//
//    public UserQuery(Session session) {
//        this.session = session;
//    }
//
//    public List<User> getAllUsers(){
//        Transaction tx = null;
//        List<User> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "From User";
//
//            users = session.createQuery(hql).list();
//
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString() + user.getName() + user.getSurname());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//    public List<User> getUsersWithParameter(String userType, Map<String, String> params) {
//        Transaction tx = null;
//        List<User> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "From " + userType + " where ";
//
//            for (String key : params.keySet()) {
//                hql += key + " " + params.get(key);
//                if (params.size() > 1) hql += " AND ";
//                params.remove(key);
//            }
//
//            users = session.createQuery(hql).list();
//
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString() + user.getName() + user.getSurname());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//
//    public List<User> getUsersLiteraryWork(Integer literaryWorkId) {
//        List<User> users = null;
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select users from LibraryCard where " +
//                    "libraryfund = (select libraryfund from WorksInFund where " +
//                    "libraryfund = (From LibraryFund where given=true AND tohandout=true) " +
//                    "AND literaryworks = (From LiteraryWorks where id = :literaryWorkId))";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("literaryWorkId", literaryWorkId);
//            users = query.list();
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString() + user.getName() + user.getSurname());
//            }
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//
//        tx.commit();
//        return users;
//    }
//
//    public List<User> getUsersEdition(String editionName) {
//        Transaction tx = null;
//        List<User> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select users from LibraryCard where" +
//                    " libraryfund = (From LibraryFund where name = :editionName)";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("editionName", editionName);
//            users = query.list();
//
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString() + user.getName() + user.getSurname());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//
//    public List<LibraryCard> getUsersTimeEdition(String litararyWorkName, String startDate, String endDate) {
//        Transaction tx = null;
//        List<LibraryCard> data = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select users, libraryfund from LibraryCard where " +
//                    "dateofissue>=:startDate AND dateofissue<=:endDate " +
//                    "AND libraryfund = (select libraryfund from WorksInFund where " +
//                    "literaryworks.name = :literaryWorkName)";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("literaryWorkName", litararyWorkName);
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = formatter.parse(startDate);
//            Date dateEnd = formatter.parse(endDate);
//            Timestamp timeStartDate = new Timestamp(dateStart.getTime());
//            Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
//            query.setParameter("startDate", timeStartDate);
//            query.setParameter("endDate", timeEndDate);
//            data = query.list();
//
//
//            for (Iterator<LibraryCard> it = data.iterator(); it.hasNext(); ) {
//                LibraryCard d = it.next();
//                System.out.println(d.toString());
//            }
//
//        } catch (HibernateException|ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return data;
//    }
//
//    public List<User> getUsersLibrarian(Integer librarianId, String startDate, String endDate){
//        Transaction tx = null;
//        List<User> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select users from LibraryCard where " +
//                    "dateofissue>=:startDate AND dateofissue<=:endDate " +
//                    "AND librarian.id = :librarianId";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("librarianId", librarianId);
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = formatter.parse(startDate);
//            Date dateEnd = formatter.parse(endDate);
//            Timestamp timeStartDate = new Timestamp(dateStart.getTime());
//            Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
//            query.setParameter("startDate", timeStartDate);
//            query.setParameter("endDate", timeEndDate);
//            users = query.list();
//
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString());
//            }
//
//        } catch (HibernateException|ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//
//    public List<User> getUsersOverdue(){
//        Transaction tx = null;
//        List<User> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select users from CardToHandOut where " +
//                    "returned=false AND " +
//                    "periodforissuing < :currentDate";
//
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String c = LocalDate.now().toString();
//            Date curDate = formatter.parse(c);
//            Timestamp timeStartDate = new Timestamp(curDate.getTime());
//            Query query = session.createQuery(hql);
//            query.setParameter("currentDate", timeStartDate);
//            users = query.list();
//
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString());
//            }
//
//        } catch (HibernateException|ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//
//    public List<User> getUsersNotVisit(String startDate, String endDate){
//        Transaction tx = null;
//        List<User> users = new ArrayList<>();
//        try {
//            tx = session.beginTransaction();
//            String hql1 = "From User U " +
//                    "left join LibraryCard L ON U.id=L.id where L.id IS NULL";
//
//            String hql2 = "select users from LibraryCard where " +
//                    "dateofissue<=:startDate OR dateofissue>=:endDate";
//
//
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = formatter.parse(startDate);
//            Date dateEnd = formatter.parse(endDate);
//            Timestamp timeStartDate = new Timestamp(dateStart.getTime());
//            Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
//            Query query1 = session.createQuery(hql1);
//            Query query2 =session.createQuery(hql2);
//            query2.setParameter("startDate", timeStartDate);
//            query2.setParameter("endDate", timeEndDate);
//            List<User> users1 = query1.list();
//            List<User> users2 = query2.list();
//
//            users.addAll(users1);
//            users.addAll(users2);
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = it.next();
//                System.out.println(user.toString());
//            }
//
//        } catch (HibernateException|ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return users;
//    }
//
//    public void getUsersCountLibrarian(String startDate, String endDate){
//        Transaction tx = null;
//        List<Integer> users = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select count(users) from LibraryCard " +
//                    "where librarian=(from Librarians) " +
//                    "AND dateofissue>=:startDate AND dateofissue<=:endDate";
//
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = formatter.parse(startDate);
//            Date dateEnd = formatter.parse(endDate);
//            Timestamp timeStartDate = new Timestamp(dateStart.getTime());
//            Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
//            Query query = session.createQuery(hql);
//            query.setParameter("startDate", timeStartDate);
//            query.setParameter("endDate", timeEndDate);
//            users = query.list();
//            System.out.println(users);
//
////            for (Iterator<Integer> it = users.iterator(); it.hasNext(); ) {
////                Integer user = it.next();
////                System.out.println(user.toString());
////            }
//
//        } catch (HibernateException|ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//    }


}