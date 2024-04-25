package com.project.resourcesharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String userId;
    String userName;
    String email;
    String password;
    String street;
    String State;
    String county;
    String aptNo;
    String pinCode;
}
