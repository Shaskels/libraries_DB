package main.controller;

import main.Repos.LibrariansRepo;
import main.Repos.LibraryFundRepo;
import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/libraryFund", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryFundController {

    @Autowired
    private LibraryFundRepo libraryFundRepo;
    @Autowired
    private LibrariansRepo librariansRepo;

    @GetMapping("/getAll")
    public List<LibraryFund> getAll(){
        return libraryFundRepo.getAllFund();
    }
    @GetMapping("/getAllForCard")
    public List<LibraryFund> getAllC(){
        return libraryFundRepo.getAllFundForCard();
    }

    @GetMapping("/getById")
    public LibraryFund getById(@RequestParam Integer id){
        return libraryFundRepo.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        libraryFundRepo.delete(id);
    }

    @PostMapping("/add/existArticle")
    public void addA(@RequestParam Integer type, @RequestParam Integer id){
        libraryFundRepo.saveArticle2(id,type);
    }

    @PostMapping("/add/existDis")
    public void addD(@RequestParam String object, @RequestParam Integer id){
        libraryFundRepo.saveDis2(id,object);
    }

    @PostMapping("/add/existMag")
    public void addM(@RequestParam String frequency,
                     @RequestParam String format,
                     @RequestParam String thematics,
                     @RequestParam Integer id){
        libraryFundRepo.saveMag2(id, frequency,format,thematics);
    }

    @PostMapping("/add/existNew")
    public void addNew(@RequestParam String frequency,
                     @RequestParam String format,
                     @RequestParam String thematics,
                       @RequestParam String territory,
                     @RequestParam Integer id){
        libraryFundRepo.saveNew2(id, frequency,format,thematics, territory);
    }

    @PostMapping("/add/existNovel")
    public void addN(@RequestParam Integer type, @RequestParam Integer id){
        libraryFundRepo.saveNov2(id,type);
    }

    @PostMapping("/add/existPoetry")
    public void addP(@RequestParam String theme, @RequestParam Integer id){
        libraryFundRepo.savePoe2(id,theme);
    }

    @PostMapping("/add/existStory")
    public void addS(@RequestParam Integer type, @RequestParam Integer id){
        libraryFundRepo.saveStory2(id,type);
    }

    @PostMapping("/add/articles")
    public Articles addArticle(@RequestParam String name,
                    @RequestParam Integer shelf,
                    @RequestParam Integer rack,
                    @RequestParam Boolean tohandout,
                    @RequestParam Boolean given,
                    @RequestParam String dateofreceipt,
                    @RequestParam Integer readingroomsId,
                    @RequestParam Short type){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Articles libraryFund = new Articles();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfArticles(type);
        return libraryFundRepo.saveArticle(libraryFund);
    }

    @PostMapping("/add/dissertations")
    public Dissertations addDissertations(@RequestParam String name,
                           @RequestParam Integer shelf,
                           @RequestParam Integer rack,
                           @RequestParam Boolean tohandout,
                           @RequestParam Boolean given,
                           @RequestParam String dateofreceipt,
                           @RequestParam Integer readingroomsId,
                           @RequestParam String object){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Dissertations libraryFund = new Dissertations();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setObject(object);
        return libraryFundRepo.saveDissertation(libraryFund);
    }

    @PostMapping("/add/magazines")
    public Magazines adMagazines(@RequestParam String name,
                            @RequestParam Integer shelf,
                            @RequestParam Integer rack,
                            @RequestParam Boolean tohandout,
                            @RequestParam Boolean given,
                            @RequestParam String dateofreceipt,
                            @RequestParam Integer readingroomsId,
                            @RequestParam String frequency,
                            @RequestParam String format,
                            @RequestParam String thematics){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Magazines libraryFund = new Magazines();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setFrequency(frequency);
        libraryFund.setFormat(format);
        libraryFund.setThematics(thematics);
        return libraryFundRepo.saveMagazines(libraryFund);
    }

    @PostMapping("/add/newspapers")
    public Newspapers addNewspapers(@RequestParam String name,
                            @RequestParam Integer shelf,
                            @RequestParam Integer rack,
                            @RequestParam Boolean tohandout,
                            @RequestParam Boolean given,
                            @RequestParam String dateofreceipt,
                            @RequestParam Integer readingroomsId,
                            @RequestParam String territory,
                            @RequestParam String frequency,
                            @RequestParam String format,
                            @RequestParam String thematics){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Newspapers libraryFund = new Newspapers();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTerritory(territory);
        libraryFund.setFrequency(frequency);
        libraryFund.setFormat(format);
        libraryFund.setThematics(thematics);
        return libraryFundRepo.saveNewspaper(libraryFund);
    }

    @PostMapping("/add/novels")
    public Novels addNovels(@RequestParam String name,
                              @RequestParam Integer shelf,
                              @RequestParam Integer rack,
                              @RequestParam Boolean tohandout,
                              @RequestParam Boolean given,
                              @RequestParam String dateofreceipt,
                              @RequestParam Integer readingroomsId,
                              @RequestParam Short type){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Novels libraryFund = new Novels();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfNovel(type);
        return libraryFundRepo.saveNovels(libraryFund);
    }

    @PostMapping("/add/poetry")
    public Poetry addPoetry(@RequestParam String name,
                          @RequestParam Integer shelf,
                          @RequestParam Integer rack,
                          @RequestParam Boolean tohandout,
                          @RequestParam Boolean given,
                          @RequestParam String dateofreceipt,
                          @RequestParam Integer readingroomsId,
                          @RequestParam String theme){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Poetry libraryFund = new Poetry();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTheme(theme);
        return libraryFundRepo.savePoetry(libraryFund);
    }

    @PostMapping("/add/story")
    public Story addStory(@RequestParam String name,
                          @RequestParam Integer shelf,
                          @RequestParam Integer rack,
                          @RequestParam Boolean tohandout,
                          @RequestParam Boolean given,
                          @RequestParam String dateofreceipt,
                          @RequestParam Integer readingroomsId,
                          @RequestParam Short type){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Story libraryFund = new Story();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfStory(type);
        return libraryFundRepo.saveStory(libraryFund);
    }

    @DeleteMapping("/delete/article")
    public void deleteArticle(@RequestParam Integer id){
        libraryFundRepo.deleteArticle(id);
    }

    @DeleteMapping("/delete/dissertations")
    public void deleteDis(@RequestParam Integer id){
        libraryFundRepo.deleteDissertation(id);
    }

    @DeleteMapping("/delete/magazines")
    public void deleteMag(@RequestParam Integer id){
        libraryFundRepo.deleteMagazines(id);
    }

    @DeleteMapping("/delete/newspapers")
    public void deleteNews(@RequestParam Integer id){
        libraryFundRepo.deleteNewspapers(id);
    }

    @DeleteMapping("/delete/novels")
    public void deleteNovels(@RequestParam Integer id){
        libraryFundRepo.deleteNovels(id);
    }

    @DeleteMapping("/delete/poetry")
    public void deletePoe(@RequestParam Integer id){
        libraryFundRepo.deletePoetry(id);
    }

    @DeleteMapping("/delete/story")
    public void deleteStory(@RequestParam Integer id){
        libraryFundRepo.deleteStory(id);
    }


    @PutMapping("/update/articles")
    public Articles updateArticle(@RequestParam String name,
                               @RequestParam Integer shelf,
                               @RequestParam Integer rack,
                               @RequestParam Boolean tohandout,
                               @RequestParam Boolean given,
                               @RequestParam String dateofreceipt,
                               @RequestParam Integer readingroomsId,
                               @RequestParam Short type,
                                  @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Articles libraryFund = new Articles();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfArticles(type);
        libraryFund.setId(id);
        return libraryFundRepo.updateArticle(libraryFund);
    }

    @PutMapping("/update/dissertations")
    public Dissertations updateDissertations(@RequestParam String name,
                                          @RequestParam Integer shelf,
                                          @RequestParam Integer rack,
                                          @RequestParam Boolean tohandout,
                                          @RequestParam Boolean given,
                                          @RequestParam String dateofreceipt,
                                          @RequestParam Integer readingroomsId,
                                          @RequestParam String object,
                                             @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Dissertations libraryFund = new Dissertations();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setObject(object);
        libraryFund.setId(id);
        return libraryFundRepo.updateDis(libraryFund);
    }

    @PutMapping("/update/magazines")
    public Magazines updateMagazines(@RequestParam String name,
                                 @RequestParam Integer shelf,
                                 @RequestParam Integer rack,
                                 @RequestParam Boolean tohandout,
                                 @RequestParam Boolean given,
                                 @RequestParam String dateofreceipt,
                                 @RequestParam Integer readingroomsId,
                                 @RequestParam String frequency,
                                 @RequestParam String format,
                                 @RequestParam String thematics,
                                     @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Magazines libraryFund = new Magazines();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setFrequency(frequency);
        libraryFund.setFormat(format);
        libraryFund.setThematics(thematics);
        libraryFund.setId(id);
        return libraryFundRepo.updateMag(libraryFund);
    }

    @PutMapping("/update/newspapers")
    public Newspapers updateNewspapers(@RequestParam String name,
                                    @RequestParam Integer shelf,
                                    @RequestParam Integer rack,
                                    @RequestParam Boolean tohandout,
                                    @RequestParam Boolean given,
                                    @RequestParam String dateofreceipt,
                                    @RequestParam Integer readingroomsId,
                                    @RequestParam String territory,
                                    @RequestParam String frequency,
                                    @RequestParam String format,
                                    @RequestParam String thematics,
                                       @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Newspapers libraryFund = new Newspapers();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTerritory(territory);
        libraryFund.setFrequency(frequency);
        libraryFund.setFormat(format);
        libraryFund.setThematics(thematics);
        libraryFund.setId(id);
        return libraryFundRepo.updateNew(libraryFund);
    }

    @PutMapping("/update/novels")
    public Novels updateNovels(@RequestParam String name,
                            @RequestParam Integer shelf,
                            @RequestParam Integer rack,
                            @RequestParam Boolean tohandout,
                            @RequestParam Boolean given,
                            @RequestParam String dateofreceipt,
                            @RequestParam Integer readingroomsId,
                            @RequestParam Short type,
                               @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Novels libraryFund = new Novels();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfNovel(type);
        libraryFund.setId(id);
        return libraryFundRepo.updateNov(libraryFund);
    }

    @PutMapping("/update/poetry")
    public Poetry updatePoetry(@RequestParam String name,
                            @RequestParam Integer shelf,
                            @RequestParam Integer rack,
                            @RequestParam Boolean tohandout,
                            @RequestParam Boolean given,
                            @RequestParam String dateofreceipt,
                            @RequestParam Integer readingroomsId,
                            @RequestParam String theme,
                               @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Poetry libraryFund = new Poetry();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTheme(theme);
        libraryFund.setId(id);
        return libraryFundRepo.updatePoe(libraryFund);
    }

    @PutMapping("/update/story")
    public Story updateStory(@RequestParam String name,
                          @RequestParam Integer shelf,
                          @RequestParam Integer rack,
                          @RequestParam Boolean tohandout,
                          @RequestParam Boolean given,
                          @RequestParam String dateofreceipt,
                          @RequestParam Integer readingroomsId,
                          @RequestParam Short type,
                             @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateofreceipt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Story libraryFund = new Story();
        libraryFund.setName(name);
        libraryFund.setShelf(shelf);
        libraryFund.setRack(rack);
        libraryFund.setTohandout(tohandout);
        libraryFund.setGiven(given);
        libraryFund.setDateofreceipt(date);
        libraryFund.setReadingrooms(readingRoom);
        libraryFund.setTypeOfStory(type);
        libraryFund.setId(id);
        return libraryFundRepo.updateStory(libraryFund);
    }

    @GetMapping("/givenToUser")
    public List<LibraryFund> getFundUsersLit(@RequestParam Integer userId){
        return libraryFundRepo.getFundUsersLit(userId);
    }

    @GetMapping("/usedByUser")
    public List<LibraryFund> getFundUserUsed(@RequestParam Integer userId){
        return libraryFundRepo.getFundUsersLitUsed(userId);
    }

    @GetMapping("/receiptDate")
    public List<LibraryFund> getFundReceiptDate(@RequestParam String startDate,
                                                @RequestParam String endDate){
        return libraryFundRepo.getWorkReceipt(startDate,endDate);
    }

    @GetMapping("/hasLiteraryWork")
    public List<LibraryFund> getHasLiteraryWork(@RequestParam Integer workId){
        return libraryFundRepo.getFundLibraryWork(workId);
    }

    @GetMapping("/hasAuthor")
    public List<LibraryFund> getHasAuthor(@RequestParam Integer authorId){
        return libraryFundRepo.getFundAuthor(authorId);
    }

    @GetMapping("/articles")
    public List<LibraryFund> getArticles(){
        return libraryFundRepo.getFundWithParam("Articles");
    }

    @GetMapping("/magazines")
    public List<LibraryFund> getMagazines(){
        return libraryFundRepo.getFundWithParam("Magazines");
    }

    @GetMapping("/newspapers")
    public List<LibraryFund> getNewspapers(){
        return libraryFundRepo.getFundWithParam("Newspapers");
    }

    @GetMapping("/novels")
    public List<LibraryFund> getNovels(){
        return libraryFundRepo.getFundWithParam("Novels");
    }

    @GetMapping("/dissertations")
    public  List<LibraryFund> getDissertations() {
        return libraryFundRepo.getFundWithParam("Dissertations");
    }

    @GetMapping("/poetry")
    public  List<LibraryFund> getPoetry() {
        return libraryFundRepo.getFundWithParam("Poetry");
    }

    @GetMapping("/story")
    public  List<LibraryFund> getStory() {
        return libraryFundRepo.getFundWithParam("Story");
    }

}
