package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;

import java.util.List;

public interface BookService {
  //도서 카테코리 목록 조회 쿼리 기능
  public List<BookCategoryDTO> selectCategoryList();

  //도서 등록 쿼리 기능
  public void insertBook(BookDTO bookDTO);

  //카테고리 등록 쿼리 기능
  // - 1. 중복 확인, 2. 카테고리 등록  해야하므로 여기서는 하나의 기능만 만들어두고
  // 서비스에서 만든 기능에 서비스 임플에서 두가지 기능을 넣어서 기능을 구현할 수 있도록 한다.
  public int insertCategory(String cateName);

  // 도서 이미지 등록
  public void insertImgs(BookDTO bookDTO);

  // 다음에 들어갈 BOOK_CODE를 조회
  public int getNextBookCode();
}
