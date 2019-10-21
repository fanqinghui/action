package com.wish.action.service;

import com.wish.action.dao.sys.entity.User;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/6/26 17:33
 */
public interface SysUserService {

  public User getUserById(Long id);

  User getUserByUsername(String username);
}
