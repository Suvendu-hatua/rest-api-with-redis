package com.spring_boot.redis.RestAPI_Redis.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private String id;
    private String name;
    private String expiry;
    private String companyName;
    private int count;

}
