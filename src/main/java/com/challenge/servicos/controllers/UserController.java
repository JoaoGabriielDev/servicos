package com.challenge.servicos.controllers;

import com.challenge.servicos.entities.User;
import com.challenge.servicos.repositories.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(value = "API REST Servicos")
@CrossOrigin(origins = "*")
public class UserController {

    public UserRepository userRepository;

    @GetMapping("buscar-user")
    @ApiOperation(value = "return user")
    public List<User> getName() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id,
                            @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails);
        return userRepository.findById(id).get();
    }

    @PostMapping("salvar-user")
    @ApiOperation(value = "save user")
    public User salvarUser(@RequestBody User user ) {
        return userRepository.save(user);
    }

    @DeleteMapping("deleta-user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "delete user")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @ApiOperation(value = "update user")
    @PutMapping("atualiza-user/{id}")
    public User atualizaUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
