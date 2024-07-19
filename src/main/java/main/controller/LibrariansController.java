package main.controller;

import main.Repos.LibrariansRepo;
import main.entity.Librarians;
import main.entity.Production;
import main.entity.ReadingRoom;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/librarian", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibrariansController {

    @Autowired
    private LibrariansRepo librariansRepo;

    @GetMapping("/getAll")
    public List<Librarians> getAll(){
        return librariansRepo.getAllLibrarians();
    }

    @GetMapping("/readingRoom/getAll")
    public List<ReadingRoom> getAllReading(){
        return librariansRepo.getReadingRooms();
    }

    @GetMapping("/getById")
    public Librarians getById(@RequestParam Integer id){
        return librariansRepo.getById(id);
    }

    @GetMapping("/login")
    public List<Librarians> getLogin(@RequestParam String login,
                                     @RequestParam String password){
        return librariansRepo.login(login, password);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        librariansRepo.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String surname,
                    @RequestParam String name,
                    @RequestParam String patronymic,
                    @RequestParam Integer readingroomsId,
                    @RequestParam String login,
                    @RequestParam String password){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        Librarians librarian = new Librarians();
        librarian.setName(name);
        librarian.setSurname(surname);
        librarian.setPatronymic(patronymic);
        librarian.setReadingrooms(readingRoom);
        librarian.setLogin(login);
        librarian.setPassword(password);
        librariansRepo.save(librarian);
    }

    @PutMapping("/update")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer readingroomsId,
                       @RequestParam String login,
                       @RequestParam String password,
                       @RequestParam Integer id){
        ReadingRoom readingRoom = librariansRepo.getByIdRR(readingroomsId);
        Librarians librarian = new Librarians();
        librarian.setName(name);
        librarian.setSurname(surname);
        librarian.setPatronymic(patronymic);
        librarian.setReadingrooms(readingRoom);
        librarian.setLogin(login);
        librarian.setPassword(password);
        librarian.setId(id);
        librariansRepo.update(librarian);
    }

    @GetMapping("/workInRR")
    public  List<Librarians> getLibrariansReadingRoom(@RequestParam Integer readingRoomId){
        return librariansRepo.getLibrarianReadingRoom(readingRoomId);
    }

    @GetMapping("/productions")
    public List<Production> getProductions() {
        return librariansRepo.getUsersCountLibrarian();
    }
}
