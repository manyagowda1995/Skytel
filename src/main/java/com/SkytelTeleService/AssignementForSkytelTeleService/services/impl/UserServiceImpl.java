package com.SkytelTeleService.AssignementForSkytelTeleService.services.impl;

import com.SkytelTeleService.AssignementForSkytelTeleService.entities.User;
import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDetails;
import com.SkytelTeleService.AssignementForSkytelTeleService.payload.UserDto;
import com.SkytelTeleService.AssignementForSkytelTeleService.repositories.UserRepository;
import com.SkytelTeleService.AssignementForSkytelTeleService.services.UserService;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    //create user
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.mapper.map(userDto, User.class);
        User saveUser = this.userRepo.save(user);

        return this.mapper.map(saveUser, UserDto.class);
    }

    //get users by given limit
    @Override
    public List<UserDto> getUsersByLimit(int number) {

        List<User> users = this.userRepo.findUserByLimit(number);
         return users.stream().map((user) -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    //get users by age whose age is greater than given age
    @Override
    public Set<UserDetails> getUsersByAge(int years, int months, int days) {

        int givenAge = (years * 365) + (months * 30) + days;
        var curDate = LocalDate.now();
        List<User> users = this.userRepo.findAll();

        Set<UserDetails> userDetails = new HashSet<>();
        ListIterator<User> itr = users.listIterator();
        while (itr.hasNext()){
            User user = itr.next();

            String[] age2 = (user.getDateOfBirth()).split("-");
            int y = Integer.parseInt(age2[0]);
            int m = Integer.parseInt(age2[1]);
            int d = Integer.parseInt(age2[2]);

            var a = LocalDate.of(y, m, d);
            var p = Period.between(a, curDate);
            int age = (p.getYears() * 365) + (p.getMonths() * 30) + p.getDays();

            if (age>givenAge){
                UserDetails userDetail = new UserDetails();
                userDetail.setId(user.getId());
                userDetail.setName(user.getName());
                userDetail.setAge(String.format("%s years,%s months,%s days",p.getYears(),p.getMonths(),p.getDays()));
                userDetails.add(userDetail);
            }

        }
        return userDetails;
    }
}
