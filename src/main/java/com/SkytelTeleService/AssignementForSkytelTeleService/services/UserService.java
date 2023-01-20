package com.SkytelTeleService.AssignementForSkytelTeleService.services;

import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDetails;
import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {

    //create user
    UserDto createUser(UserDto userDto);

    //get users by given limit
    List<UserDto> getUsersByLimit(int number);

    //get users by age whose age is greater then given age
    Set<UserDetails> getUsersByAge(int years, int months, int days);

}
