package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class BookCategoryController {
  private final BookService bookService;

  //카테고리 목록 조회 api
  //~/categories
  @GetMapping("")
  public List<BookCategoryDTO> getCateList(){
    return bookService.selectCategoryList();
  }

  //카테고리 등록 api
  //post ~/categories
  @PostMapping("")
  public int insertCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    //넘어오는 객체의 키와 배개변수에 작성한 dto 클래스와 변수가 일치해야함
    //bookCategoryDTO에서 cateName만 가져오면 되므로 아래처럼 getter를 불러온다.
    //등록 성공 -> 1 리턴
    //등록 실패 -> 0 리턴
    return bookService.insertCategory(bookCategoryDTO.getCateName());

  }

}
