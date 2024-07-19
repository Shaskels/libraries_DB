package main.Repos;


import javax.persistence.Column;
import javax.persistence.EntityManager;

import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserRepo {

    @Autowired
    private EntityManager entityManager;


    public List<User> getAllUsers(){
        String hql = "From User where deleted = 0";
        return entityManager.createQuery(hql, User.class).getResultList();
    }

    public User getById(Integer id){
        return entityManager.find(User.class,id);

    }


    public Library getByIdL(Integer id){
        return entityManager.find(Library.class,id);
    }

    public void delete(Integer id){
        User user = entityManager.find(User.class,id);
        user.setDeleted();
    }
    public Pupils updatePup(Pupils user) {
        return entityManager.merge(user);
    }
    public Pensioners updatePen(Pensioners user) {
        return entityManager.merge(user);
    }
    public ScientificWorkers updateScience(ScientificWorkers user) {
        return entityManager.merge(user);
    }
    public Students updateStud(Students user) {
        return entityManager.merge(user);
    }
    public Workers updateWork(Workers user) {
        return entityManager.merge(user);
    }
    public Teachers updateTeach(Teachers user) {
        return entityManager.merge(user);
    }
    public OtherResidents updateOther(OtherResidents user) {
        return entityManager.merge(user);
    }
    public void savePupils(Pupils user) {
        entityManager.persist(user);
    }
    public void savePensioners(Pensioners user){entityManager.persist(user);}
    public void saveScientific(ScientificWorkers user){entityManager.persist(user);}
    public void saveStudent(Students user){entityManager.persist(user);}
    public void saveTeachers(Teachers user){entityManager.persist(user);}
    public void saveWorkers(Workers user){entityManager.persist(user);}
    public void saveOtherResidents(OtherResidents user){entityManager.persist(user);}
    public void savePupils2(Integer id, String schoolname, Integer classNum, Character letter) {
        String sql = "insert into pupils values(:id, :schoolname, :classNum, :letter)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("schoolname", schoolname);
        query.setParameter("classNum", classNum);
        query.setParameter("letter", letter);
        query.executeUpdate();
    }

    public void savePensioners2(Integer id, Integer age, String pensioncertificatenumber) {
        String sql = "insert into pensioners values(:id, :pension, :age)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("pension", pensioncertificatenumber);
        query.setParameter("age", age);
        query.executeUpdate();
    }

    public void saveScientific2(Integer id, String organizationname, String scientifictopic, String post) {
        String sql = "insert into scientificworkers values(:id, :org, :topic, :post)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("org", organizationname);
        query.setParameter("topic", scientifictopic);
        query.setParameter("post", post);
        query.executeUpdate();
    }

    public void saveStudent2(Integer id, String nameoftheeducationalintitution, String faculty, Integer course,
                             String groupnumber) {
        String sql = "insert into students values(:id, :org, :fuc, :course,:group)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("org", nameoftheeducationalintitution);
        query.setParameter("fuc", faculty);
        query.setParameter("course", course);
        query.setParameter("group", groupnumber);
        query.executeUpdate();
    }

    public void saveTeach2(Integer id, String nameoftheeducationalintitution, String subject, String post) {
        String sql = "insert into teachers values(:id, :org, :sub, :post)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("org", nameoftheeducationalintitution);
        query.setParameter("subject", subject);
        query.setParameter("post", post);
        query.executeUpdate();
    }

    public void saveWorkers2(Integer id, String organizationname, String specialization) {
        String sql = "insert into workers values(:id, :org, :spec)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("org", organizationname);
        query.setParameter("spec", specialization);
        query.executeUpdate();
    }

    public void saveOther2(Integer id, String fieldofactivity) {
        String sql = "insert into otherresidents values(:id, :field)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("field", fieldofactivity);
        query.executeUpdate();
    }


    public void deletePupil(Integer id){
        String sql = "delete from pupils where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deletePensioners(Integer id){
        String sql = "delete from pensioners where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteScientific(Integer id){
        String sql = "delete from scientificworkers where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteStudents(Integer id){
        String sql = "delete from students where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteTeachers(Integer id){
        String sql = "delete from teachers where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteWorkers(Integer id){
        String sql = "delete from workers where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteOther(Integer id){
        String sql = "delete from otherresidents where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
    public List<User> getUsersWithParameter(String userType, Map<String, String> params){
        String hql = "From " + userType;

        if (!params.isEmpty()) {
            hql += " where ";
            for (String key : params.keySet()) {
                hql += key + " " + params.get(key);
                if (params.size() > 1) hql += " AND ";
                params.remove(key);
            }
        }

        System.out.println(hql);

        return entityManager.createQuery(hql).getResultList();
    }

    public User getUsersLiteraryWork(Integer literaryWorkId){
        String hql = "select l.users from LibraryCard l join WorksInFund w " +
                "ON l.libraryfund.id = w.libraryfund.id " +
                "where l.libraryfund.given=true " +
                "AND l.libraryfund.tohandout=true AND w.literaryworks.id = :literaryWorkId AND l.users.deleted = 0";

        Query query = entityManager.createQuery(hql);

        query.setParameter("literaryWorkId", literaryWorkId);
        List<User> users = query.getResultList();
        if (users.size() == 1) return users.get(0);
        else if (users.isEmpty()) return null;
        else return users.get(users.size()-1);
    }

    public User getUsersEdition(Integer libraryFundId){
        String hql = "select l.users from LibraryCard l where" +
                    " l.libraryfund.id = :editionId AND l.libraryfund.given=true AND l.libraryfund.tohandout=true AND l.users.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("editionId", libraryFundId);
        List<User> users = query.getResultList();
        if (users.size() == 1) return users.get(0);
        else if (users.isEmpty()) return null;
        else return users.get(users.size()-1);
    }

    public List<User> getUsersLibrarianTime(Integer librarianId, String startDate, String endDate){
        String hql = "select l.users from LibraryCard l where " +
                "l.dateofissue>=:startDate AND l.dateofissue<=:endDate " +
                "AND l.librarian.id = :librarianId AND l.users.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("librarianId", librarianId);
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
        return query.getResultList();
    }

    public List<User> getUsersOverdue(){
        String hql = "select c.users from CardToHandOut c where " +
                "c.returned=false AND " +
                "c.periodforissuing < :currentDate AND c.users.deleted = 0";

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String c = LocalDate.now().toString();
        Date curDate = null;
        try {
            curDate = formatter.parse(c);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Timestamp timeStartDate = new Timestamp(curDate.getTime());
        Query query = entityManager.createQuery(hql);
        query.setParameter("currentDate", timeStartDate);
        return query.getResultList();
    }

    public List<User> getUsersNotVisit(String startDate, String endDate){
        List<User> users = new ArrayList<>();
        String hql1 = "From User U " +
                "left join LibraryCard L ON U.id=L.users.id where L.users.id IS NULL AND U.deleted = 0";

        String hql2 = "select distinct l.users from LibraryCard l where " +
                "l.dateofissue<=:startDate OR l.dateofissue>=:endDate AND l.users.deleted = 0";


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
        Query query1 = entityManager.createQuery(hql1);
        Query query2 = entityManager.createQuery(hql2);
        query2.setParameter("startDate", timeStartDate);
        query2.setParameter("endDate", timeEndDate);
        List<Object[]> tmp = query1.getResultList();
        List<User> users2 = query2.getResultList();
        users.addAll(users2);
        for (Object[] result : tmp){
            users.add((User) result[0]);
        }
        return users;
    }



}
