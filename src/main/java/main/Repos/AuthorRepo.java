package main.Repos;


import main.entity.Author;
import main.entity.Librarians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorRepo {

    @Autowired
    private EntityManager entityManager;

    public List<Author> getAllAuthors(){
        List<Author> authors = null;
        String hql = "From Author where deleted = 0";
        authors = entityManager.createQuery(hql, Author.class).getResultList();
        return authors;
    }

    public Author getById(Integer id){
        return entityManager.find(Author.class,id);
    }

    public Author update(Author author) {
        return entityManager.merge(author);
    }

    public void delete(Integer id){
        Author author = getById(id);
        author.setDeleted();
    }

    public void save(Author author) {
        entityManager.persist(author);
    }
}
