package main.controller;

import main.Repos.LibraryRepo;
import main.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/library", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

    @Autowired
    LibraryRepo libraryRepo;

    @GetMapping("/getAll")
    public List<Library> getAll(){
        return libraryRepo.getAllLibrary();
    }
}
