package com.example.demo.myFirstProject.services;

import com.example.demo.myFirstProject.badRequestException.BadRequestException;
import com.example.demo.myFirstProject.model.User;
import com.example.demo.myFirstProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike(name);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(User.builder()
                .id(user.getId())
                .name(user.getName())
                .last_name(user.getLast_name())
                .birthday(user.getBirthday())
                .build());
    }

    public void replace(User user) {
        findByIdOrThrowBadRequestException(user.getId());
        User user1 = User.builder()
                .id(user.getId())
                .name(user.getName())
                .last_name(user.getLast_name())
                .birthday(user.getBirthday())
                .build();
        userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }


}
