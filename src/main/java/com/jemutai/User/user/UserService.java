package com.jemutai.User.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final  UserRepo userRepo;


     public UserDTO createUser(UserDTO userDTO){
         User user = convertToEntity(userDTO);
         user= userRepo.save(user);

         return  convertToDTO(user);
     }
//method to convert model to DTo
    private UserDTO convertToDTO(User user) {
         if (user==null){
             return null;
         }

         UserDTO userDTO = new UserDTO();
         userDTO.setEmail(user.getEmail());
         userDTO.setName(user.getName());
         return  userDTO;

    }
//method to find all users
   public  List < UserDTO>  findAllUsers(){
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

//method to find a user by id
    public  UserDTO  findUserById(@PathVariable Long id){
        User user = userRepo.findById(id).orElse(null);
        return  convertToDTO(user);
    }
//map DTO to  entity method.
    private User convertToEntity(UserDTO userDTO) {

         User user = new User();

         user.setName(userDTO.getName());
         user.setEmail(userDTO.getEmail());
        return  user;
    }

    //method to delete user

    public  void deleteUser(Long id){
         userRepo.deleteById(id);
    }

    public UserDTO updateUser( Long id,UserDTO userDTO) {
         User  existingUser = userRepo.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setEmail(userDTO.getEmail());
        existingUser.setName(userDTO.getName());
        return convertToDTO(existingUser);




    }
}
