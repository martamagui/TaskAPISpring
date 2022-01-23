package com.example.MichiTaskServer.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users" )
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping(path="{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.delete(userId);
    }

    @PutMapping(path = "{userId}")
    public void editUser(@PathVariable("userId")Integer userId,
                         @RequestParam(required = false) String firstName,
                         @RequestParam(required = false) String lastName,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String pwd
                         ){
        userService.editUser(userId, firstName,lastName, email, pwd);
    }
}
