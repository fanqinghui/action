package com.wish.action.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author fqh
 * @Description: ${todo}
 * @date 2019/10/21上午12:07
 */
@Data
public class LoginParam implements Serializable {

   String userName;
   String password;
}
