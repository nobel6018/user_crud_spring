package com.cloudy.simplespring.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// DDL
// create table USER (
//     USER_ID BIGINT not null primary key,
//     ACCOUNT_ID VARCHAR(255),
//     PASSWORD VARCHAR(255)
// );
@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String accountId;
    private String password;

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
