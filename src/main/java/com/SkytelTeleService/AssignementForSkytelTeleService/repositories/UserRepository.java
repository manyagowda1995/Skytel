package com.SkytelTeleService.AssignementForSkytelTeleService.repositories;

import com.SkytelTeleService.AssignementForSkytelTeleService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

      //this method is not working thats why i will use Query
      // List<User> findOrderedBySeatNumberLimitedTo(int number);

    @Query(value = "select * from Users LIMIT 0, :number", nativeQuery = true)
    List<User> findUserByLimit(int number);


}
