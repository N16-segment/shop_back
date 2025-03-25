package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  //도서 카테코리 목록 조회 쿼리
  public List<BookCategoryDTO> selectCategoryList();

  //도서 등록 쿼리
  public void insertBook(BookDTO bookDTO);

  //카테고리명 중복 확인 쿼리 - mapper는 단순 쿼리
  public String isUsableCateName(String cateName);

  //카테고리 등록 쿼리
  public int insertCategory(String cateName);


  /// /////////////////////////////////////////////

  // 도서 이미지 등록 쿼리
  //public void insertImgs(List<ImgDTO> imgList);
  //BookDTO에 List<ImgDTO>를 넣었기 때문에 필요한 데이터를 모두 불러올 수 있다.
  public void insertImgs(BookDTO bookDTO);

  // 다음에 들어갈 BOOK_CODE를 조회하는 쿼리 매개변수는 빈 값채우는 것인데 이번에는 없다.
  public int getNextBookCode();

}
