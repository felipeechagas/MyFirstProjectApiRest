package com.example.demo.myFirstProject.controllers;

import com.example.demo.myFirstProject.model.User;
import com.example.demo.myFirstProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        List<User> list = userService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id) {
        User user = userService.findByIdOrThrowBadRequestException(id);
        return ResponseEntity.ok().body(user);
    }

    //http://localhost:8080/user/find?name=nome
    @GetMapping(path = "/find")
    public ResponseEntity<List<User>> findByName(@RequestParam String name) {
        return ResponseEntity.ok().body(userService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> replace(@RequestBody User user) {
        userService.replace(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Deleta um item da lista
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}