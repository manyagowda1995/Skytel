package com.SkytelTeleService.AssignementForSkytelTeleService.controllers;

import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDetails;
import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDto;
import com.SkytelTeleService.AssignementForSkytelTeleService.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/assignment")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    //get users by given limit

    @GetMapping("/users/limit/{number}")
    public ResponseEntity<List<UserDto>> getUsersByLimit(@PathVariable("number") int number){
        return new ResponseEntity<>(this.userService.getUsersByLimit(number), HttpStatus.OK);
    }

    //get users by age whose age is greater then given age

    @GetMapping("/users/y/{years}/m/{months}/d/{days}")
    public ResponseEntity<Set<UserDetails>> getUsersByAge(@PathVariable int years, @PathVariable int months, @PathVariable int days){
        return new ResponseEntity<>(this.userService.getUsersByAge(years, months, days), HttpStatus.OK);
    }
}
