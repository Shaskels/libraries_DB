package main.Repos;


import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.desktop.QuitEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class LibraryFundRepo {

    @Autowired
    private EntityManager entityManager;

    public List<LibraryFund> getAllFund(){
        String hql = "From LibraryFund where deleted = 0";
        return entityManager.createQuery(hql, LibraryFund.class).getResultList();
    }

    public List<LibraryFund> getAllFundForCard(){
        String hql = "From LibraryFund where deleted = 0 AND given = false";
        return entityManager.createQuery(hql, LibraryFund.class).getResultList();
    }

    public LibraryFund getById(Integer id){
        return entityManager.find(LibraryFund.class,id);
    }

    public void delete(Integer id){
        LibraryFund librarian = entityManager.find(LibraryFund.class,id);
        librarian.setDeleted();
    }
    public LibraryFund update(LibraryFund libraryFund) {
        return entityManager.merge(libraryFund);
    }

    public Articles saveArticle(Articles fund) {
        return entityManager.merge(fund);
    }
    public Dissertations saveDissertation(Dissertations fund) {
        return entityManager.merge(fund);
    }
    public Magazines saveMagazines(Magazines fund) {
        return entityManager.merge(fund);
    }
    public Newspapers saveNewspaper(Newspapers fund) {
        return entityManager.merge(fund);
    }
    public Novels saveNovels(Novels fund) {
        return entityManager.merge(fund);
    }
    public Poetry savePoetry(Poetry fund) {
        return entityManager.merge(fund);
    }
    public Story saveStory(Story fund) {
        return entityManager.merge(fund);
    }

    public void saveArticle2(Integer id, Integer type) {
        String sql = "insert into articles values(:id, :type)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("type", type);
        query.executeUpdate();
    }

    public void saveDis2(Integer id, String object) {
        String sql = "insert into dissertations values(:id, :object)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("object", object);
        query.executeUpdate();
    }

    public void saveMag2(Integer id, String frequency, String format, String thematics) {
        String sql = "insert into magazines values(:id, :frequency, :format, :thematics )";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("frequency", frequency);
        query.setParameter("format", format);
        query.setParameter("thematics", thematics);
        query.executeUpdate();
    }

    public void saveNew2(Integer id, String frequency, String format, String thematics,String territory) {
        String sql = "insert into newspapers values(:id, :territory ,:frequency, :format, :thematics )";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("frequency", frequency);
        query.setParameter("format", format);
        query.setParameter("thematics", thematics);
        query.setParameter("territory", territory);
        query.executeUpdate();
    }

    public void saveNov2(Integer id, Integer type) {
        String sql = "insert into novels values(:id, :type)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("type", type);
        query.executeUpdate();
    }

    public void savePoe2(Integer id, String theme) {
        String sql = "insert into poetry values(:id, :theme)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("theme", theme);
        query.executeUpdate();
    }

    public void saveStory2(Integer id, Integer type) {
        String sql = "insert into story values(:id, :type)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("type", type);
        query.executeUpdate();
    }
    public void deleteArticle(Integer id){
        String sql = "delete from article where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteDissertation(Integer id){
        String sql = "delete from dissertations where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteMagazines(Integer id){
        String sql = "delete from magazines where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteNewspapers(Integer id){
        String sql = "delete from newspapers where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteNovels(Integer id){
        String sql = "delete from novels where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deletePoetry(Integer id){
        String sql = "delete from poetry where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteStory(Integer id){
        String sql = "delete from story where id=:id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public Articles updateArticle(Articles fund) {
        return entityManager.merge(fund);
    }

    public Dissertations updateDis(Dissertations fund) {
        return entityManager.merge(fund);
    }

    public Magazines updateMag(Magazines fund) {
        return entityManager.merge(fund);
    }

    public Newspapers updateNew(Newspapers fund) {
        return entityManager.merge(fund);
    }

    public Novels updateNov(Novels fund) {
        return entityManager.merge(fund);
    }

    public Poetry updatePoe(Poetry fund) {
        return entityManager.merge(fund);
    }

    public Story updateStory(Story fund) {
        return entityManager.merge(fund);
    }
    public List<LibraryFund> getFundWithParam(String tableName){
        String hql = "From " + tableName;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }



    public List<LibraryFund> getFundUsersLit(Integer userId){
        String hql = "select l.libraryfund from LibraryCard l " +
                "where l.users.id=:userId AND l.librarian.readingrooms.library=l.users.library" +
                " AND l.libraryfund.tohandout=true AND l.libraryfund.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<LibraryFund> getFundUsersLitUsed(Integer userId){
        String hql = "select l.libraryfund from LibraryCard l " +
                "where l.users.id =:userId AND l.librarian.readingrooms.library=l.users.library" +
                " AND l.libraryfund.tohandout=false AND l.libraryfund.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<LibraryFund> getWorkReceipt(String startDate, String endDate){
        String hql = "from LibraryFund" +
                " where dateofreceipt>=:startDate AND dateofreceipt<=:endDate AND deleted = 0";

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
        Query query = entityManager.createQuery(hql);
        query.setParameter("startDate", timeStartDate);
        query.setParameter("endDate", timeEndDate);
        return query.getResultList();
    }

    public List<LibraryFund> getFundLibraryWork(Integer workId){
        String hql = "select w.libraryfund from WorksInFund w" +
                " where w.literaryworks =:workId AND w.libraryfund.deleted = 0";

        Query query = entityManager.createQuery(hql);
        query.setParameter("workId", workId);
        return query.getResultList();
    }

    public List<LibraryFund> getFundAuthor(Integer authorId){
        String hql = "from LiteraryWorks where authors.id = :authorId AND deleted = 0";
        Query query = entityManager.createQuery(hql);
        query.setParameter("authorId", authorId);
        List<LiteraryWorks> works = query.getResultList();

        hql = "select libraryfund from WorksInFund" +
                " where literaryworks=:work AND deleted = 0";
        query = entityManager.createQuery(hql);

        List<LibraryFund> fund = new ArrayList<>();
        for (LiteraryWorks w : works){
            query.setParameter("work", w);
            fund.addAll(query.getResultList());
        }
        return fund;
    }
}
