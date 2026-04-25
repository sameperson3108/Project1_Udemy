package controllers;

import dao.PersonDAO;
import models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.PersonValidator;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    private final PersonValidator personValidator;

    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("{/id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }

    @GetMapping("{/new}")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PatchMapping("{/id}")
    public String update(@PathVariable("id") int id, Model model) {
        return null;
    }
}
