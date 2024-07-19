package main.query;

import main.entity.LibraryFund;
import main.entity.LiteraryWorks;
import main.entity.User;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LibraryFundQuery {
//    Session session;
//
//    public LibraryFundQuery(Session session) {
//        this.session = session;
//    }
//    public List<LibraryFund> getFundUsersLit(Integer userId){
//        Transaction tx = null;
//        List<LibraryFund> fund = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select libraryfund from LibraryCard " +
//                    "where users.id=:userId AND librarian.readingrooms.library=users.library" +
//                    " AND libraryfund.tohandout=true";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("userId", userId);
//            fund = query.list();
//
//            for (Iterator<LibraryFund> it = fund.iterator(); it.hasNext(); ) {
//                LibraryFund l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return fund;
//    }
//
//    public List<LibraryFund> getFundUsersLitUsed(Integer userId){
//        Transaction tx = null;
//        List<LibraryFund> fund = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select libraryfund from LibraryCard " +
//                    "where users.id=:userId AND librarian.readingrooms.library=users.library" +
//                    " AND libraryfund.tohandout=false";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("userId", userId);
//            fund = query.list();
//
//            for (Iterator<LibraryFund> it = fund.iterator(); it.hasNext(); ) {
//                LibraryFund l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return fund;
//    }
//
//
//    public List<LibraryFund> getWorkReceipt(String startDate, String endDate){
//        Transaction tx = null;
//        List<LibraryFund> fund = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "from LibraryFund" +
//                    " where dateofreceipt>=:startDate AND dateofreceipt<=:endDate";
//
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = formatter.parse(startDate);
//            Date dateEnd = formatter.parse(endDate);
//            Timestamp timeStartDate = new Timestamp(dateStart.getTime());
//            Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
//            Query query = session.createQuery(hql);
//            query.setParameter("startDate", timeStartDate);
//            query.setParameter("endDate", timeEndDate);
//            fund = query.list();
//
//            for (Iterator<LibraryFund> it = fund.iterator(); it.hasNext(); ) {
//                LibraryFund l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException | ParseException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return fund;
//    }
//
//    public List<LibraryFund> getFundNum(Integer workId){
//        Transaction tx = null;
//        List<LibraryFund> fund = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select libraryfund from WorksInFund" +
//                    " where literaryworks.id=:workId";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("workId", workId);
//            fund = query.list();
//
//            for (Iterator<LibraryFund> it = fund.iterator(); it.hasNext(); ) {
//                LibraryFund l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return fund;
//    }
//
//    public List<LibraryFund> getFundNumAuthor(Integer authorId){
//        Transaction tx = null;
//        List<LibraryFund> fund = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select libraryfund from WorksInFund" +
//                    " where literaryworks.authors.id=:authorId";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("authorId", authorId);
//            fund = query.list();
//
//            for (Iterator<LibraryFund> it = fund.iterator(); it.hasNext(); ) {
//                LibraryFund l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return fund;
//    }

}
