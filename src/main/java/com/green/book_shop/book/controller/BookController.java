package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.dto.ImgDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;

  //도서 등록 api
  //post ~/books
  @PostMapping("")
  public void regBook(BookDTO bookDTO,
                      @RequestParam(name = "mainImg", required = true) MultipartFile mainImg,
                      @RequestParam(name = "subImg", required = true) MultipartFile subImg
                      ){
   //required = true는 이미지를 무조건 화면에 출력하게 한다.

    //데이터 확인
//    System.out.println(bookDTO);
//    System.out.println(mainImg.getOriginalFilename());
//    System.out.println(subImg.getOriginalFilename());

    //regBook에서 해야될 3가지 내용(아래)
    //첨부파일(도서 이미지) 업로드
    //mainImg.getOriginalFilename(); //원본 파일을 받아 올수 있는 원본파일명

    //쿼리의 빈 값을 채워주기 위해서 넣어줘야 한다.(메인 이미지, 상세 이미지)
    String mainAttachedFileName = uploadUtil.fileUpload(mainImg); //실제로 첨부된 파일명은 fileUpload()메서드에서 랜덤으로 만들어짐
    String subAttachedFileName = uploadUtil.fileUpload(subImg); // 상세 이미지

    //다음에 들어갈 BOOK_CODE 조회
    // -> BOOK 테이블에 인써트 하기 전에, BOOK 테이블에 저장된 BOOK_CODE 중 가장 큰 수를 조회
    int nextBookCode = bookService.getNextBookCode();

    //BOOK 테이블에 데이터 INSERT -> 쿼리실행 bookDTO 매개변수가 쿼리의 빈값을 채우는 것
    bookDTO.setBookCode(nextBookCode);
    bookService.insertBook(bookDTO);

    //bookDTO에 이미지 데이터 저장
    List<ImgDTO> imgList = new ArrayList<>(); //실제 데이터가 들어갈 통
    ImgDTO mainImgDTO = new ImgDTO();
    mainImgDTO.setOriginFileName(mainImg.getOriginalFilename());
    mainImgDTO.setAttachedFileName(mainAttachedFileName);
    mainImgDTO.setIsMain("Y");
    mainImgDTO.setBookCode(nextBookCode);

    ImgDTO subImgDTO = new ImgDTO();
    subImgDTO.setOriginFileName(subImg.getOriginalFilename());
    subImgDTO.setAttachedFileName(subAttachedFileName);
    subImgDTO.setIsMain("N");
    subImgDTO.setBookCode(nextBookCode);

    imgList.add(mainImgDTO);
    imgList.add(subImgDTO);
    bookDTO.setImgList(imgList);

    //BOOK_IMG 테이블에 도서 이미지 정보 INSERT -> 쿼리실행
    bookService.insertImgs(bookDTO); // 매개변수로 bookDTO가 들어와야 한다.

  }




}
