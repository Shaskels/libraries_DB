package main.Repos;

import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class LibraryCardRepo {
    @Autowired
    EntityManager entityManager;

    public List<LibraryCard> getAllCards(){
        List<LibraryCard> libraryCards = null;
        String hql = "From LibraryCard where deleted = 0";
        libraryCards = entityManager.createQuery(hql, LibraryCard.class).getResultList();
        return libraryCards;
    }

    public LibraryCard getById(Integer id){
        return entityManager.find(LibraryCard.class,id);
    }

    public void delete(Integer id){
        LibraryCard l = getById(id);
        l.setDeleted();
    }

    public void deleteCardToHand(Integer id){
        String sql = "delete from cardtohandout where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteToReadInRoom(Integer id){
        String sql = "delete from cardtoreadinroom where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void saveToHandOut2(Integer id, Boolean returned, String date) {
        String sql = "insert into cardtohandout values(:id,:returned, :date)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("returned", returned);
        query.setParameter("date", date);
        query.executeUpdate();
    }

    public void saveToReadInRoom2(Integer id, String time1, String time2) {
        String sql = "insert into cardtoreadinroom values(:id,:time1, :time2)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("time1", time1);
        query.setParameter("time2", time2);
        query.executeUpdate();
    }

    public CardToReadInRoom updateToReadInRoom(CardToReadInRoom libraryCard) {
        return entityManager.merge(libraryCard);
    }

    public CardToHandOut updateToHandOut(CardToHandOut libraryCard) {
        return entityManager.merge(libraryCard);
    }

    public void saveToHandOut(CardToHandOut libraryCard) {
        entityManager.persist(libraryCard);
    }

    public void saveToReadInRoom(CardToReadInRoom libraryCard) {
        entityManager.persist(libraryCard);
    }


    public List<LibraryCard> getUsersTimeEdition(Integer literaryWorkId, String startDate, String endDate) {

        String hql1 = "select libraryfund from WorksInFund where " +
        "literaryworks = :literaryWorkId";
        Query query = entityManager.createQuery(hql1);
        query.setParameter("literaryWorkId", literaryWorkId);
        List<LibraryFund> fund = query.getResultList();
        String hql = "from LibraryCard where " +
                "dateofissue>=:startDate AND dateofissue<=:endDate " +
                "AND libraryfund = :fund AND deleted = 0";
        query = entityManager.createQuery(hql);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = formatter.parse(startDate);
            dateEnd = formatter.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Timestamp timeStartDate = new Timestamp(dateStart.getTime());
        Timestamp timeEndDate = new Timestamp(dateEnd.getTime());
        query.setParameter("startDate", timeStartDate);
        query.setParameter("endDate", timeEndDate);

        List<LibraryCard> cards = new ArrayList<>();
        for (LibraryFund f : fund) {

            query.setParameter("fund", f);

            cards.addAll(query.getResultList());
        }
//        String sql = "select LibraryCard.id, LibraryCard.dateofissue, LibraryCard.libraryfund, LibraryCard.users, LibraryCard.librarian from LibraryCard join WorksInFund" +
//                " where LibraryCard.dateofissue>=:startDate AND LibraryCard.dateofissue<=:endDate AND WorksInFund.literaryworks = :literaryWorkId";




        return cards;
    }
}
