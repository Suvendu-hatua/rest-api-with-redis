package com.spring_boot.redis.RestAPI_Redis.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medicine {
    private String id;
    private String name;
    private String expiry;
    private String companyName;
    private int count;

}
