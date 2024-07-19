package main.controller;


import main.Repos.LibraryFundRepo;
import main.Repos.LiteraryWorkRepo;
import main.Repos.WorksInFundRepo;
import main.entity.LibraryFund;
import main.entity.LiteraryWorks;
import main.entity.WorksInFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/worksInFund", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorksInFundController {

    @Autowired
    WorksInFundRepo worksInFundRepo;
    @Autowired
    LibraryFundRepo libraryFundRepo;
    @Autowired
    LiteraryWorkRepo literaryWorkRepo;

    @GetMapping("/getAll")
    public List<WorksInFund> getAll(){
        return worksInFundRepo.getAllWorksInFund();
    }

    @GetMapping("/getById")
    public WorksInFund getById(@RequestParam Integer id){
        return worksInFundRepo.getById(id);
    }

    @GetMapping("/getWorks")
    public List<LiteraryWorks> getWorks(@RequestParam Integer id) {
        return  worksInFundRepo.getWorks(id);
    }
    @PostMapping("/add")
    public void add(@RequestParam Integer libraryfundId,
                    @RequestParam Integer literaryworksId){

        WorksInFund worksInFund = new WorksInFund();
        LibraryFund libraryFund = libraryFundRepo.getById(libraryfundId);
        LiteraryWorks literaryWorks = literaryWorkRepo.getById(literaryworksId);
        worksInFund.setLibraryfund(libraryFund);
        worksInFund.setLiteraryworks(literaryWorks);
        worksInFundRepo.save(worksInFund);
    }
}


