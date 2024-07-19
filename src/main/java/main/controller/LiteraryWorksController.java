package main.controller;

import main.Repos.LiteraryWorkRepo;
import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/literaryWorks", produces = MediaType.APPLICATION_JSON_VALUE)
public class LiteraryWorksController {

    @Autowired
    LiteraryWorkRepo literaryWorkRepo;

    @GetMapping("/getAll")
    public List<LiteraryWorks> getAll(){
        return literaryWorkRepo.getAllLiteraryWorks();
    }

    @GetMapping("/getById")
    public LiteraryWorks getById(@RequestParam Integer id){
        return literaryWorkRepo.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        literaryWorkRepo.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String name,
                    @RequestParam Integer authorId){
        Author author = literaryWorkRepo.getByIdA(authorId);
        LiteraryWorks literaryWorks = new LiteraryWorks();
        literaryWorks.setName(name);
        literaryWorks.setAuthors(author);
        literaryWorkRepo.save(literaryWorks);
    }

    @PutMapping("/update")
    public void update(@RequestParam String name,
                       @RequestParam Integer authorId,
                       @RequestParam Integer id){
        Author author = literaryWorkRepo.getByIdA(authorId);
        LiteraryWorks literaryWorks = new LiteraryWorks();
        literaryWorks.setName(name);
        literaryWorks.setAuthors(author);
        literaryWorks.setId(id);
        literaryWorkRepo.update(literaryWorks);
    }

    @GetMapping("/onShelf")
    public List<LiteraryWorks> getWorksOnShelf(@RequestParam Integer shelf,
                                               @RequestParam Integer readingRoomId){
        return literaryWorkRepo.getWorkShelf(shelf,readingRoomId);
    }

    @GetMapping("/popular")
    public  List<Popular> getPopular(){
        return literaryWorkRepo.getPopular();
    }
}
