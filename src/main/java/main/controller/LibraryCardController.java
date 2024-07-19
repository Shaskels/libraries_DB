package main.controller;


import main.Repos.LibrariansRepo;
import main.Repos.LibraryCardRepo;
import main.Repos.LibraryFundRepo;
import main.Repos.UserRepo;
import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/libraryCard", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryCardController {

    @Autowired
    LibraryCardRepo libraryCardRepo;
    @Autowired
    LibrariansRepo librariansRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    LibraryFundRepo libraryFundRepo;

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        libraryCardRepo.delete(id);
    }
    @GetMapping("/getAll")
    public List<LibraryCard> getAll(){
        return libraryCardRepo.getAllCards();
    }

    @GetMapping("/getById")
    public LibraryCard getById(@RequestParam Integer id){
        return libraryCardRepo.getById(id);
    }

    @DeleteMapping("/delete/handOut")
    public void deleteH(@RequestParam Integer id){
        libraryCardRepo.deleteCardToHand(id);
    }

    @DeleteMapping("/delete/readInRoom")
    public void deleteR(@RequestParam Integer id){
        libraryCardRepo.deleteToReadInRoom(id);
    }

    @PostMapping("/add/existHandOut")
    public  void addH(@RequestParam Boolean returned,
                      @RequestParam String periodforissuing,
                        @RequestParam Integer id){
        libraryCardRepo.saveToHandOut2(id,returned,periodforissuing);
    }

    @PostMapping("/add/existReadInRoom")
    public void addRR(@RequestParam String timeofissue,
                      @RequestParam String returntime,
                      @RequestParam Integer id) {
        libraryCardRepo.saveToReadInRoom2(id, timeofissue, returntime);
    }

    @PostMapping("/add/handOut")
    public void addHandOut(@RequestParam String dateofissue,
                    @RequestParam Integer libraryFundId,
                    @RequestParam Integer librarianId,
                    @RequestParam Integer userId,
                    @RequestParam Boolean returned,
                    @RequestParam String periodforissuing){
        Librarians librarians = librariansRepo.getById(librarianId) ;
        User user = userRepo.getById(userId);
        LibraryFund libraryFund = libraryFundRepo.getById(libraryFundId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date period = null;
        try {
            date = formatter.parse(dateofissue);
            period = formatter.parse(periodforissuing);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        CardToHandOut libraryCard = new CardToHandOut();
        libraryCard.setLibrarian(librarians);
        libraryCard.setUsers(user);
        libraryCard.setLibraryfund(libraryFund);
        libraryCard.setDateofissue(date);
        libraryCard.setReturned(returned);
        libraryCard.setPeriodforissuing(period);
        libraryCardRepo.saveToHandOut(libraryCard);
    }

    @PostMapping("/add/readInRoom")
    public void addReadInRoom(@RequestParam String dateofissue,
                           @RequestParam Integer libraryFundId,
                           @RequestParam Integer librarianId,
                           @RequestParam Integer userId,
                           @RequestParam String timeofissue,
                           @RequestParam String returntime){
        Librarians librarians = librariansRepo.getById(librarianId) ;
        User user = userRepo.getById(userId);
        LibraryFund libraryFund = libraryFundRepo.getById(libraryFundId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        Time time1 = null;
        Time time2 = null;
        try {
            date = formatter.parse(dateofissue);
            time1 = new Time(formatter1.parse(timeofissue).getTime());
            time2 = new Time(formatter1.parse(returntime).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        CardToReadInRoom libraryCard = new CardToReadInRoom();
        libraryCard.setLibrarian(librarians);
        libraryCard.setUsers(user);
        libraryCard.setLibraryfund(libraryFund);
        libraryCard.setDateofissue(date);
        libraryCard.setTimeofissue(time1);
        libraryCard.setReturntime(time2);
        libraryCardRepo.saveToReadInRoom(libraryCard);
    }

    @PutMapping("/update/readInRoom")
    public void updateR(@RequestParam String dateofissue,
                       @RequestParam Integer libraryFundId,
                       @RequestParam Integer librarianId,
                       @RequestParam Integer userId,
                       @RequestParam String timeofissue,
                       @RequestParam String returntime,
                       @RequestParam Integer id){
        Librarians librarians = librariansRepo.getById(librarianId) ;
        User user = userRepo.getById(userId);
        LibraryFund libraryFund = libraryFundRepo.getById(libraryFundId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        Time time1 = null;
        Time time2 = null;
        try {
            date = formatter.parse(dateofissue);
            time1 = new Time(formatter1.parse(timeofissue).getTime());
            time2 = new Time(formatter1.parse(returntime).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        CardToReadInRoom libraryCard = new CardToReadInRoom();
        libraryCard.setLibrarian(librarians);
        libraryCard.setUsers(user);
        libraryCard.setLibraryfund(libraryFund);
        libraryCard.setDateofissue(date);
        libraryCard.setReturntime(time2);
        libraryCard.setTimeofissue(time1);
        libraryCard.setId(id);

        libraryCardRepo.updateToReadInRoom(libraryCard);
    }

    @PutMapping("/update/handOut")
    public void update(@RequestParam String dateofissue,
                       @RequestParam Integer libraryFundId,
                       @RequestParam Integer librarianId,
                       @RequestParam Integer userId,
                       @RequestParam Boolean returned,
                       @RequestParam String periodforissuing,
                       @RequestParam Integer id){
        Librarians librarians = librariansRepo.getById(librarianId) ;
        User user = userRepo.getById(userId);
        LibraryFund libraryFund = libraryFundRepo.getById(libraryFundId);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date date1 = null;
        try {
            date = formatter.parse(dateofissue);
            date1 = formatter.parse(periodforissuing);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        CardToHandOut libraryCard = new CardToHandOut();
        libraryCard.setLibrarian(librarians);
        libraryCard.setUsers(user);
        libraryCard.setLibraryfund(libraryFund);
        libraryCard.setDateofissue(date);
        libraryCard.setPeriodforissuing(date1);
        libraryCard.setReturned(returned);
        libraryCard.setId(id);

        libraryCardRepo.updateToHandOut(libraryCard);
    }
    @GetMapping("/getUsersWithCard")
    public List<LibraryCard> getUsersWithCard(@RequestParam Integer id,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        return libraryCardRepo.getUsersTimeEdition(id,startDate,endDate);
    }
}
