package team.symmetry.ResumeBack.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.exceptions.UserNotFoundException;
import team.symmetry.ResumeBack.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        return userService.getUserById(id);
    }
    @GetMapping("/findByName")
    public UserDto findByName(@RequestParam("name") String name) throws UserNotFoundException{
        return userService.findByName(name);
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) throws UserNotFoundException{
        userService.deleteUserById(id);
    }
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDTO){
        return userService.updateUser(id, userDTO);
    }

    @GetMapping("/session")
    public UserDto getUserSession(){
        return userService.getUserSession();
    }
}
