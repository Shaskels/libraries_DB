package main.controller;

import main.Repos.UserRepo;
import main.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userRepo.getAllUsers();
    }

    @GetMapping("/getById")
    public User getById(@RequestParam Integer id){
        return userRepo.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) {
        userRepo.delete(id);
    }
    @PostMapping("/add/existPupils")
    public void addPup(@RequestParam String schoolname,
                       @RequestParam Integer classNum,
                       @RequestParam Character letter,
                       @RequestParam Integer id){
        userRepo.savePupils2(id, schoolname, classNum, letter);
    }

    @PostMapping("/add/existPensioners")
    public void addPup(@RequestParam String pensioncertificatenumber,
                       @RequestParam Integer age,
                       @RequestParam Integer id){
        userRepo.savePensioners2(id,age,pensioncertificatenumber);
    }

    @PostMapping("/add/existScientific")
    public void addPup(@RequestParam String organizationname,
                       @RequestParam String scientifictopic,
                       @RequestParam String post,
                       @RequestParam Integer id) {
        userRepo.saveScientific2(id, organizationname, scientifictopic, post);
    }

    @PostMapping("/add/existStudents")
    public void addPup(@RequestParam String nameoftheeducationalintitution,
                       @RequestParam String faculty,
                       @RequestParam Integer course,
                       @RequestParam String groupnumber,
                       @RequestParam Integer id) {
        userRepo.saveStudent2(id, nameoftheeducationalintitution, faculty, course, groupnumber);
    }

    @PostMapping("/add/existTeacher")
    public void addPu(@RequestParam String nameoftheeducationalintitution,
                       @RequestParam String subject,
                       @RequestParam String post,
                       @RequestParam Integer id) {
        userRepo.saveTeach2(id, nameoftheeducationalintitution, subject, post);
    }

    @PostMapping("/add/existWorker")
    public void addPu(@RequestParam String organizationname,
                      @RequestParam String specialization,
                      @RequestParam Integer id) {
        userRepo.saveWorkers2(id, organizationname, specialization);
    }

    @PostMapping("/add/existOther")
    public void addPu(@RequestParam String fieldofactivity,
                      @RequestParam Integer id) {
        userRepo.saveOther2(id, fieldofactivity);
    }



    @PutMapping("/update/pupils")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer libraryId,
                       @RequestParam String schoolname,
                       @RequestParam Integer classNum,
                       @RequestParam Character letter,
                       @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        Pupils user = new Pupils();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLetter(letter);
        user.setSchoolname(schoolname);
        user.setClassNum(classNum);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updatePup(user);
    }

    @PutMapping("/update/pensioners")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer libraryId,
                       @RequestParam String pensioncertificatenumber,
                       @RequestParam Integer age,
                       @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        Pensioners user = new Pensioners();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setAge(age);
        user.setPensioncertificatenumber(pensioncertificatenumber);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updatePen(user);
    }

    @PutMapping("/update/scientificWorkers")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer libraryId,
                       @RequestParam String organizationname,
                       @RequestParam String scientifictopic,
                       @RequestParam String post,
                       @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        ScientificWorkers user = new ScientificWorkers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setPost(post);
        user.setScientifictopic(scientifictopic);
        user.setOrganizationname(organizationname);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updateScience(user);
    }

    @PutMapping("/update/students")
    public void update(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer libraryId,
                       @RequestParam String nameoftheeducationalintitution,
                       @RequestParam String faculty,
                       @RequestParam Integer course,
                       @RequestParam String groupnumber,
                       @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        Students user = new Students();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setNameoftheeducationalintitution(nameoftheeducationalintitution);
        user.setFaculty(faculty);
        user.setCourse(course);
        user.setGroupnumber(groupnumber);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updateStud(user);
    }

    @PutMapping("/update/teachers")
    public void updateT(@RequestParam String surname,
                       @RequestParam String name,
                       @RequestParam String patronymic,
                       @RequestParam Integer libraryId,
                       @RequestParam String nameoftheeducationalintitution,
                       @RequestParam String subject,
                       @RequestParam String post,
                       @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        Teachers user = new Teachers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setNameoftheeducationalintitution(nameoftheeducationalintitution);
        user.setPost(post);
        user.setSubject(subject);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updateTeach(user);
    }

    @PutMapping("/update/workers")
    public void updateT(@RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String patronymic,
                        @RequestParam Integer libraryId,
                        @RequestParam String organizationname,
                        @RequestParam String specialization,
                        @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        Workers user = new Workers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setSpecialization(specialization);
        user.setOrganizationname(organizationname);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updateWork(user);
    }

    @PutMapping("/update/otherResidents")
    public void updateT(@RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String patronymic,
                        @RequestParam Integer libraryId,
                        @RequestParam String fieldofactivity,
                        @RequestParam Integer id){
        Library library = userRepo.getByIdL(libraryId);
        OtherResidents user = new OtherResidents();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setFieldofactivity(fieldofactivity);
        user.setLibrary(library);
        user.setId(id);
        userRepo.updateOther(user);
    }

    @DeleteMapping("/delete/pupils")
    public  void deletePup(@RequestParam Integer id){
        userRepo.deletePupil(id);
    }

    @DeleteMapping("/delete/pensioners")
    public  void deletePen(@RequestParam Integer id){
        userRepo.deletePensioners(id);
    }

    @DeleteMapping("/delete/scientificWorkers")
    public  void deleteScience(@RequestParam Integer id){
        userRepo.deleteScientific(id);
    }

    @DeleteMapping("/delete/students")
    public  void deleteStud(@RequestParam Integer id){
        userRepo.deleteStudents(id);
    }

    @DeleteMapping("/delete/teachers")
    public  void deleteTeach(@RequestParam Integer id){
        userRepo.deleteTeachers(id);
    }

    @DeleteMapping("/delete/workers")
    public  void deleteWork(@RequestParam Integer id){
        userRepo.deleteWorkers(id);
    }

    @DeleteMapping("/delete/otherResidents")
    public  void deleteOther(@RequestParam Integer id){
        userRepo.deleteOther(id);
    }


    @PostMapping("/add/pupils")
    public void addPupils(@RequestParam String surname,
                    @RequestParam String name,
                    @RequestParam String patronymic,
                    @RequestParam Integer libraryId,
                    @RequestParam String schoolname,
                    @RequestParam Integer classNum,
                    @RequestParam Character letter){
        Library library = userRepo.getByIdL(libraryId);
        Pupils user = new Pupils();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setSchoolname(schoolname);
        user.setClassNum(classNum);
        user.setLetter(letter);
        userRepo.savePupils(user);
    }

    @PostMapping("/add/pensioners")
    public void addPensioners(@RequestParam String surname,
                    @RequestParam String name,
                    @RequestParam String patronymic,
                    @RequestParam Integer libraryId,
                    @RequestParam String pensioncertificatenumber,
                    @RequestParam Integer age) {
        Library library = userRepo.getByIdL(libraryId);
        Pensioners user = new Pensioners();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setPensioncertificatenumber(pensioncertificatenumber);
        user.setAge(age);
        userRepo.savePensioners(user);
    }



    @PostMapping("/add/scientificWorkers")
    public void addScientific(@RequestParam String surname,
                              @RequestParam String name,
                              @RequestParam String patronymic,
                              @RequestParam Integer libraryId,
                              @RequestParam String organizationname,
                              @RequestParam String scientifictopic,
                              @RequestParam String post) {
        Library library = userRepo.getByIdL(libraryId);
        ScientificWorkers user = new ScientificWorkers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setOrganizationname(organizationname);
        user.setPost(post);
        user.setScientifictopic(scientifictopic);
        userRepo.saveScientific(user);
    }

    @PostMapping("/add/students")
    public void addStudents(@RequestParam String surname,
                              @RequestParam String name,
                              @RequestParam String patronymic,
                              @RequestParam Integer libraryId,
                              @RequestParam String nameoftheeducationalintitution,
                              @RequestParam String faculty,
                              @RequestParam Integer course,
                              @RequestParam String groupnumber) {
        Library library = userRepo.getByIdL(libraryId);
        Students user = new Students();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setNameoftheeducationalintitution(nameoftheeducationalintitution);
        user.setFaculty(faculty);
        user.setCourse(course);
        user.setGroupnumber(groupnumber);
        userRepo.saveStudent(user);
    }

    @PostMapping("/add/teachers")
    public void addTeachers(@RequestParam String surname,
                            @RequestParam String name,
                            @RequestParam String patronymic,
                            @RequestParam Integer libraryId,
                            @RequestParam String nameoftheeducationalintitution,
                            @RequestParam String subject,
                            @RequestParam String post) {
        Library library = userRepo.getByIdL(libraryId);
        Teachers user = new Teachers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setNameoftheeducationalintitution(nameoftheeducationalintitution);
        user.setSubject(subject);
        user.setPost(post);
        userRepo.saveTeachers(user);
    }

    @PostMapping("/add/workers")
    public void addWorkers(@RequestParam String surname,
                           @RequestParam String name,
                           @RequestParam String patronymic,
                           @RequestParam Integer libraryId,
                           @RequestParam String organizationname,
                           @RequestParam String specialization) {
        Library library = userRepo.getByIdL(libraryId);
        Workers user = new Workers();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setOrganizationname(organizationname);
        user.setSpecialization(specialization);
        userRepo.saveWorkers(user);
    }

    @PostMapping("/add/otherResidents")
    public void addOtherResid(@RequestParam String surname,
                           @RequestParam String name,
                           @RequestParam String patronymic,
                           @RequestParam Integer libraryId,
                           @RequestParam String fieldofactivity) {
        Library library = userRepo.getByIdL(libraryId);
        OtherResidents user = new OtherResidents();
        user.setSurname(surname);
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setLibrary(library);
        user.setFieldofactivity(fieldofactivity);
        userRepo.saveOtherResidents(user);
    }

    @GetMapping("/get")
    public  List<User> getUser(@RequestParam(required = false)  String surname,
                               @RequestParam(required = false)  String name,
                               @RequestParam(required = false)  String patronymic,
                               @RequestParam(required = false)  Integer libraryId){
        List<User> users;
        Map<String,String> params = new HashMap<>();


        if (!surname.equals("")) {
            params.put("surname", "= '" + surname + "'");
        }
        if (!name.equals(""))
            params.put("name", "= '" + name + "'");
        if (!patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);

        users = userRepo.getUsersWithParameter("User", params);
        return users;
    }


    @GetMapping("/pupils")
    public List<User> getPupils(@RequestParam(required = false)  String surname,
                                @RequestParam(required = false)  String name,
                                @RequestParam(required = false)  String patronymic,
                                @RequestParam(required = false)  Integer libraryId,
                                @RequestParam(required = false) String schoolname,
                                @RequestParam(required = false) Integer classNum,
                                @RequestParam(required = false) Character letter){
        List<User> users;
        Map<String,String> params = new HashMap<>();


        if (!surname.equals("")) {
            params.put("surname", "= '" + surname + "'");
        }
        if (!name.equals(""))
            params.put("name", "= '" + name + "'");
        if (!patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (!schoolname.equals(""))
            params.put("schoolname", "= '" + schoolname + "'");
        if (classNum != null)
            params.put("classNum","= " + classNum );
        if (letter != null)
            params.put("letter", "= '"+ letter +"'");

        users = userRepo.getUsersWithParameter("Pupils", params);
        return users;
    }

    @GetMapping("/pensioners")
    public List<User> getPensioners(@RequestParam(required = false) String surname,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String patronymic,
                                    @RequestParam(required = false) Integer libraryId,
                                    @RequestParam(required = false) String pensioncertificatenumber,
                                    @RequestParam(required = false) Integer age){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (pensioncertificatenumber.equals(""))
            params.put("pensioncertificatenumber", "= '" + pensioncertificatenumber + "'");
        if (age != null)
            params.put("age","= " + age);

        users = userRepo.getUsersWithParameter("Pensioners", params);
        return users;
    }

    @GetMapping("/students")
    public List<User> getStudents(@RequestParam(required = false) String surname,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String patronymic,
                                  @RequestParam(required = false) Integer libraryId,
                                  @RequestParam(required = false) String nameoftheeducationalintitution,
                                  @RequestParam(required = false) String faculty,
                                  @RequestParam(required = false) Integer course,
                                  @RequestParam(required = false) String groupnumber){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (nameoftheeducationalintitution.equals(""))
            params.put("nameoftheeducationalintitution", "= '" + nameoftheeducationalintitution + "'");
        if (faculty.equals(""))
            params.put("faculty","= '" + faculty + "'");
        if (course != null)
            params.put("course","= " + course);
        if (groupnumber.equals(""))
            params.put("groupnumber","= '" + groupnumber + "'");


        users = userRepo.getUsersWithParameter("Students", params);
        return users;
    }

    @GetMapping("/teachers")
    public List<User> getTeachers(@RequestParam(required = false) String surname,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String patronymic,
                                  @RequestParam(required = false) Integer libraryId,
                                  @RequestParam(required = false) String nameoftheeducationalintitution,
                                  @RequestParam(required = false) String subject,
                                  @RequestParam(required = false) String post){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (nameoftheeducationalintitution.equals(""))
            params.put("nameoftheeducationalintitution", "= '" + nameoftheeducationalintitution + "'");
        if (subject.equals(""))
            params.put("subject","= '" + subject + "'");
        if (post.equals(""))
            params.put("post","= '" + post + "'");

        users = userRepo.getUsersWithParameter("Teachers", params);
        return users;
    }

    @GetMapping("/workers")
    public List<User> getWorkers(@RequestParam(required = false) String surname,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String patronymic,
                                 @RequestParam(required = false) Integer libraryId,
                                 @RequestParam(required = false) String organizationname,
                                 @RequestParam(required = false) String specialization){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (organizationname.equals(""))
            params.put("organizationname", "= '" + organizationname + "'");
        if (specialization.equals(""))
            params.put("specialization","= '" + specialization + "'");

        users = userRepo.getUsersWithParameter("Workers", params);
        return users;
    }

    @GetMapping("/scientificWorkers")
    public List<User> getScientificWorkers(@RequestParam(required = false) String surname,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String patronymic,
                                           @RequestParam(required = false) Integer libraryId,
                                           @RequestParam(required = false) String organizationname,
                                           @RequestParam(required = false) String scientifictopic,
                                           @RequestParam(required = false) String post){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (organizationname.equals(""))
            params.put("organizationname", "= '" + organizationname + "'");
        if (scientifictopic.equals(""))
            params.put("scientifictopic","= '" + scientifictopic + "'");
        if (post.equals(""))
            params.put("post","= '" + post + "'");

        users = userRepo.getUsersWithParameter("ScientificWorkers", params);
        return users;
    }

    @GetMapping("/otherResidents")
    public List<User> getOtherResidents(@RequestParam(required = false) String surname,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String patronymic,
                                        @RequestParam(required = false) Integer libraryId,
                                        @RequestParam(required = false) String fieldofactivity){
        List<User> users;
        Map<String,String> params = new HashMap<>();
        if (surname.equals(""))
            params.put("surname", "= '" + surname + "'");
        if (name.equals(""))
            params.put("name", "= '" + name + "'");
        if (patronymic.equals(""))
            params.put("patronymic", "= '" + patronymic + "'");
        if (libraryId != null)
            params.put("library","= " + libraryId);
        if (fieldofactivity.equals(""))
            params.put("fieldofactivity", "= '" + fieldofactivity + "'");

        users = userRepo.getUsersWithParameter("OtherResidents", params);
        return users;
    }

    @GetMapping("/haveLiteraryWork")
    public User getUsersLiteraryWork(@RequestParam Integer id){
        return userRepo.getUsersLiteraryWork(id);
    }

    @GetMapping("/haveEdition")
    public User getUsersEdition(@RequestParam Integer id){
        return userRepo.getUsersEdition(id);
    }

    @GetMapping("/servicedLibrarian")
    public List<User> getUsersLibrarian(@RequestParam Integer id,
                                            @RequestParam String startDate,
                                            @RequestParam String endDate){
        return userRepo.getUsersLibrarianTime(id,startDate,endDate);
    }

    @GetMapping("/overdue")
    public List<User> getUsersOverdue(){
        return userRepo.getUsersOverdue();
    }


    @GetMapping("/notVisit")
    public List<User> getUsersNotVisit(@RequestParam String startDate,
                                       @RequestParam String endDate){
        return userRepo.getUsersNotVisit(startDate,endDate);
    }





}
