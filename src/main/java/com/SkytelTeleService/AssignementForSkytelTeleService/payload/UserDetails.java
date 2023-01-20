package com.SkytelTeleService.AssignementForSkytelTeleService.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private long id;

    private String name;

    private String age;
}
