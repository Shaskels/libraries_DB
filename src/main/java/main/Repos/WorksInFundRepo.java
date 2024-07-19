package main.Repos;

import main.entity.LiteraryWorks;
import main.entity.WorksInFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WorksInFundRepo {

    @Autowired
    private EntityManager entityManager;

    public List<WorksInFund> getAllWorksInFund(){
        List<WorksInFund> authors = null;
        String hql = "From WorksInFund";
        authors = entityManager.createQuery(hql, WorksInFund.class).getResultList();
        return authors;
    }

    public WorksInFund getById(Integer id){
        return entityManager.find(WorksInFund.class,id);
    }

    public WorksInFund update(WorksInFund worksInFund) {
        return entityManager.merge(worksInFund);
    }

    public List<LiteraryWorks> getWorks(Integer id){
        String hql = "select literaryworks from WorksInFund where libraryfund = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public void save(WorksInFund works) {
        entityManager.persist(works);
    }
}
