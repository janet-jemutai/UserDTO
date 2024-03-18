package com.jemutai.User.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private   final  UserService userService;

    @PostMapping("/add")

    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
    @GetMapping

  public  ResponseEntity<List<UserDTO>> findAllUsers(){
        List<UserDTO> users = userService.findAllUsers();
        return  ResponseEntity.status(HttpStatus.FOUND).body(users);
    }

    @GetMapping("/{id}")

    public  ResponseEntity<UserDTO> findUserById(@PathVariable long id){
        UserDTO user = userService.findUserById(id);
        return  ResponseEntity.status(HttpStatus.FOUND).body(user);
    }
@DeleteMapping("/{id}")

    public  ResponseEntity<UserDTO>deleteUserById(@PathVariable long id){
        userService.deleteUser(id);
    return ResponseEntity.noContent().build();
}
@PutMapping("/{id}")

    public  ResponseEntity<UserDTO> updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
       UserDTO newUser = userService.updateUser(id,userDTO);

       if (newUser==null){
           return ResponseEntity.notFound().build();
       }
    return ResponseEntity.ok(newUser);
       }

}



