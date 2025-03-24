package com.green.book_shop.user.controller;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  //회원 등록 api
  //post ~/users
  @PostMapping("")
  public boolean regUser(@RequestBody UserDTO userDTO){
    return userService.insertUser(userDTO);
  }

  //회원 목록 api
  //~/users
  @GetMapping("")
  public List<UserDTO> getUserList(){
    return userService.selectUserList();
  }


  //로그인
  //(get)~/users/login
  //@Pathvariable, @RequestParam으로 전달되는 데이터는
  //url이 노출됨 -> 아이디, 비번 유출 우려 심함

  @GetMapping("/login")
  public UserDTO login(UserDTO userDTO){
    //
    //조회된 데이터가 없으면 -> 로그인 가능 ->loginUser 가 NULL이 아니다
    //조회된 데이터가 없으면 -> 로그인 불가능 -> loginUser 가 NULL이다
    UserDTO loginUser = userService.login(userDTO);
    return loginUser;
  }


}
