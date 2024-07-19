package main.controller;


import main.Repos.AuthorRepo;
import main.entity.Author;
import main.entity.Librarians;
import main.entity.ReadingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
    AuthorRepo authorRepo;

    @GetMapping("/getAll")
    public List<Author> getAll(){
        return authorRepo.getAllAuthors();
    }

    @GetMapping("/getById")
    public Author getById(@RequestParam Integer id){
        return authorRepo.getById(id);
    }

    @DeleteMapping("/delete")
    public void del(@RequestParam Integer id){
        authorRepo.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String surname,
                    @RequestParam String name,
                    @RequestParam String patronymic){

        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setPatronymic(patronymic);

        authorRepo.save(author);
    }

    @PutMapping("/update")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer id){
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setPatronymic(patronymic);
        author.setId(id);
        authorRepo.update(author);
    }
}
