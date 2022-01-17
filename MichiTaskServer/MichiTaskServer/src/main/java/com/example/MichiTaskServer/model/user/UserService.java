package com.example.MichiTaskServer.model.user;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public List<User> getUsers(){
        return userRespository.findAll();
    }

    public void addUser(User user) {
        if(userRespository.findUserById(user.getUserId()).isPresent()){
            throw  new IllegalStateException("This user already exist");
        }else{
            userRespository.save(user);
        }
    }

    public void delete(Integer userId) {
        if(userRespository.findUserById(userId).isPresent()){
            userRespository.deleteById(userId);
        }else{
            throw  new IllegalStateException("This user doesn't exist");
        }
    }

    @Transactional
    public void editUser(Integer userId, String firstName, String lastName, String email, String pwd) {
        if(userRespository.findUserById(userId).isPresent()){
            User user = userRespository.findUserById(userId).get();
            if(firstName != null && firstName.length()>0){
                user.setFirstName(firstName);
            }
            if(lastName != null && lastName.length()>0){
                user.setLastName(lastName);
            }
            if(email != null && email.length()>0){
                user.setEmail(email);
            }
            if( pwd != null &&  pwd.length()>0){
                user.setPwd( pwd);
            }
        }else{
            throw  new IllegalStateException("This user doesn't exist");
        }
    }
}
