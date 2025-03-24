package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  private final UserMapper userMapper;

  //회원 등록 조회 구현
  @Override
  public boolean insertUser(UserDTO userDTO) {
    boolean isJoin = false;

    //아이디 중복 여부 확인
    //아이디 사용 가능하면 null 나옴
    String selectedUserId = userMapper.checkUserId(userDTO.getUserId());

    if(selectedUserId == null){
      userMapper.insertUser(userDTO);
      isJoin = true;
    }
    return isJoin;
  }

  //회원 목록 조회 구현
  @Override
  public List<UserDTO> selectUserList() {
    return userMapper.selectUserList();
  }

  //로그인 구현
  @Override
  public UserDTO login(UserDTO userDTO) {
    return userMapper.login(userDTO);
  }
}
