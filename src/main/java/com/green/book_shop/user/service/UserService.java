package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;

import java.util.List;

public interface UserService {
  //회원 등록 쿼리 기능
  public boolean insertUser(UserDTO userDTO);

  //회원 조회 쿼리 기능
  public List<UserDTO> selectUserList();

  //로그인 쿼리 기능
  public UserDTO login(UserDTO userDTO);
}
