package main.Repos;

import main.entity.Author;
import main.entity.Librarians;
import main.entity.LiteraryWorks;
import main.entity.Popular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class LiteraryWorkRepo {
    @Autowired
    private EntityManager entityManager;

    public List<LiteraryWorks> getAllLiteraryWorks(){
        List<LiteraryWorks> literaryWorks = null;
        String hql = "From LiteraryWorks where deleted = 0";
        literaryWorks = entityManager.createQuery(hql, LiteraryWorks.class).getResultList();
        return literaryWorks;
    }

    public void delete(Integer id){
        LiteraryWorks librarian = entityManager.find(LiteraryWorks.class,id);
        librarian.setDeleted();
    }
    public LiteraryWorks update(LiteraryWorks literaryWorks) {
        return entityManager.merge(literaryWorks);
    }

    public void save(LiteraryWorks librarian) {
        entityManager.persist(librarian);
    }
    public LiteraryWorks getById(Integer id){
        return entityManager.find(LiteraryWorks.class,id);
    }

    public Author getByIdA(Integer id){
        return entityManager.find(Author.class,id);
    }
    public List<LiteraryWorks> getWorkShelf(Integer shelf, Integer readingRoomId){
        String hql = "select w.literaryworks from WorksInFund w" +
                " where w.libraryfund=(from LibraryFund where given=true AND shelf=:shelf" +
                " AND readingrooms.id = :readingRoomId) AND w.literaryworks.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("shelf", shelf);
        query.setParameter("readingRoomId", readingRoomId);
        return query.getResultList();
    }

    public List<Popular> getPopular(){
        String hql = "from LiteraryWorks";
        Query query = entityManager.createQuery(hql);
        List<LiteraryWorks> literaryWorks = query.getResultList();

        String hql1 = "from LibraryCard l join WorksInFund w ON l.libraryfund = w.libraryfund " +
                "where w.literaryworks = :literaryworks";

        query = entityManager.createQuery(hql1);
        List<Popular> populars = new ArrayList<>();
        for (LiteraryWorks l: literaryWorks){
            query.setParameter("literaryworks", l);
            List<Object[]> res = query.getResultList();
            Popular popular = new Popular();
            popular.setLiteraryWorks(l);
            popular.setCount(res.size());
            populars.add(popular);
        }
        Collections.sort(populars,
                (popular1, popular2) -> Integer.compare(popular1.getCount(), popular2.getCount()));
        return populars;
    }
}
