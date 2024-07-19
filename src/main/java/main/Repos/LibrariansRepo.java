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
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class LibrariansRepo {

    @Autowired
    private EntityManager entityManager;

    public List<Librarians> getAllLibrarians(){
        List<Librarians> librarians = null;
        String hql = "From Librarians where deleted = 0";
        librarians = entityManager.createQuery(hql, Librarians.class).getResultList();
        return librarians;
    }

    public List<ReadingRoom> getReadingRooms(){
        List<ReadingRoom> librarians = null;
        String hql = "From ReadingRoom";
        librarians = entityManager.createQuery(hql, ReadingRoom.class).getResultList();
        return librarians;
    }

    public Librarians getById(Integer id){
        return entityManager.find(Librarians.class,id);
    }

    public ReadingRoom getByIdRR(Integer id) {return entityManager.find(ReadingRoom.class,id);}

    public List<Librarians> login(String login, String password){
        String hql = "From Librarians where login = :login AND password = :password AND deleted = 0";

        Query query = entityManager.createQuery(hql);

        query.setParameter("login", login);
        query.setParameter("password", password);

        return query.getResultList();
    }
    public Librarians update(Librarians librarian) {
        return entityManager.merge(librarian);
    }

    public void save(Librarians librarian) {
        entityManager.persist(librarian);
    }

    public List<Librarians> getLibrarianReadingRoom(Integer readingRoomId){
        String hql = "from Librarians " +
                "where readingrooms.id = :readingRoomId AND deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("readingRoomId", readingRoomId);
        return query.getResultList();
    }

    public List<Production> getUsersCountLibrarian(){
        String hql1 = "From Librarians where deleted = 0";
        Query query = entityManager.createQuery(hql1);
        List<Librarians> librarians = query.getResultList();

        String hql = "select l.users from LibraryCard l " +
                "where l.librarian=:librarian AND l.users.deleted = 0";

        query = entityManager.createQuery(hql);
        List<Production> productions = new ArrayList<>();
        for (Librarians l: librarians){
            query.setParameter("librarian", l);
            List<User> usersCount = query.getResultList();
            Production production = new Production();
            production.setLibrarian(l);
            production.setUserCount(usersCount.size());
            productions.add(production);
        }
        Collections.sort(productions,
                (p1, p2) -> Integer.compare(p1.getUserCount(), p2.getUserCount()));
        return  productions;
    }

    public void delete(Integer id){
        Librarians l = getById(id);
        l.setDeleted();
    }
}
