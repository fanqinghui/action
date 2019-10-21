package com.wish.action.dao.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long id;
  private String userName;
  private String password;
  private String salt;

}