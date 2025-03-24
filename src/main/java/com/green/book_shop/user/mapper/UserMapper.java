package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  //사용자 등록 쿼리
  public void insertUser(UserDTO userDTO);

  //사용자 조회 쿼리
  public List<UserDTO> selectUserList();

  //아이디 중복 체크
  public String checkUserId(String userId);

  //로그인 쿼리
  public UserDTO login(UserDTO userDTO);
}
