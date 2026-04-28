package com.solara.controllers;

import com.solara.dao.PersonDAO;
import jakarta.validation.Valid;
import com.solara.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.solara.util.PersonValidator;

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
        return "people/show";
    }

    @GetMapping("{/new}")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) return "person/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        return "people/edit";
    }

    @PatchMapping
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "people/edit";
        personValidator.validate(person, bindingResult);
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("{/id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
