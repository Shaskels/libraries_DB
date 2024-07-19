package main.query;

import main.entity.Librarians;
import main.entity.LibraryFund;

import java.util.Iterator;
import java.util.List;

public class LibrarianQuery {
//    Session session;
//
//    public LibrarianQuery(Session session) {
//        this.session = session;
//    }
//
//    public List<Librarians> getLibrarianReadingRoom(Integer readingRoomId){
//        Transaction tx = null;
//        List<Librarians> librarians = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "from Librarians " +
//                    "where readingrooms.id = :readingRoomId";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("readingRoomId", readingRoomId);
//            librarians = query.list();
//
//            for (Iterator<Librarians> it = librarians.iterator(); it.hasNext(); ) {
//                Librarians l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return librarians;
//    }

}
