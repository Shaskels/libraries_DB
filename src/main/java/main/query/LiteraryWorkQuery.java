package main.query;

import main.entity.LiteraryWorks;


import java.util.Iterator;
import java.util.List;

public class LiteraryWorkQuery {
//    Session session;
//
//    public LiteraryWorkQuery(Session session) {
//        this.session = session;
//    }
//
//    public List<LiteraryWorks> getWorkShelf(Integer shelf, Integer libraryId){
//        Transaction tx = null;
//        List<LiteraryWorks> works = null;
//        try {
//            tx = session.beginTransaction();
//            String hql = "select literaryworks from WorksInFund" +
//                    " where libraryfund.given=true AND libraryfund.shelf=:shelf" +
//                    " AND libraryfund.readingrooms.library.id=:libraryId";
//
//            Query query = session.createQuery(hql);
//            query.setParameter("shelf", shelf);
//            query.setParameter("libraryId", libraryId);
//            works = query.list();
//
//            for (Iterator<LiteraryWorks> it = works.iterator(); it.hasNext(); ) {
//                LiteraryWorks l = it.next();
//                System.out.println(l.toString());
//            }
//
//        } catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }
//        tx.commit();
//        return works;
//    }
//

}
