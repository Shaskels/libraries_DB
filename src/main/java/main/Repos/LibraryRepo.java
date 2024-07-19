package main.Repos;

import main.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LibraryRepo {

    @Autowired
    EntityManager entityManager;

    public List<Library> getAllLibrary(){
        List<Library> librarians = null;
        String hql = "From Library";
        librarians = entityManager.createQuery(hql, Library.class).getResultList();
        return librarians;
    }
}
