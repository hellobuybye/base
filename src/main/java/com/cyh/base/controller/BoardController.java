package com.cyh.base.controller;

import com.cyh.base.dto.ApiResponse;
import com.cyh.base.dto.BoardDto;
import com.cyh.base.dto.PagingInfo;
import com.cyh.base.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController 
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/api/board/getList")
    public ResponseEntity<?> getBoardList(HttpServletRequest request,
                                   BoardDto boardDto,
                                   Model model ) throws Exception {


        ApiResponse<List<BoardDto>> returnData = new ApiResponse<>();

        // /* 임시코드 S */
        // List<BoardDto> tempList = new ArrayList<>();
        // BoardDto dto = new BoardDto();
        // dto.setIdx(0);
        // dto.setSubject("게시판 샘플 1");
        // dto.setRegId("홍길동");
        // dto.setRegDt("2024-10-15");
        // tempList.add(dto);

        // dto = new BoardDto();
        // dto.setIdx(1);
        // dto.setSubject("게시판 샘플 2");
        // dto.setRegId("춘향");
        // dto.setRegDt("2024-03-24");
        // tempList.add(dto);
        
        // dto = new BoardDto();
        // dto.setIdx(2);
        // dto.setSubject("게시판 샘플 3");
        // dto.setRegId("박혁거세");
        // dto.setRegDt("2024-04-22");
        // tempList.add(dto);

        // dto = new BoardDto();
        // dto.setIdx(3);
        // dto.setSubject("게시판 샘플 4");
        // dto.setRegId("이몽룡");
        // dto.setRegDt("2024-12-26");
        // tempList.add(dto);

        // dto = new BoardDto();
        // dto.setIdx(4);
        // dto.setSubject("게시판 샘플 5");
        // dto.setRegId("최윤환");
        // dto.setRegDt("2024-03-24");
        // tempList.add(dto);

        // returnData.setBody(tempList);
        // /* 임시코드 E */

        
        returnData.setBody(boardService.getBoardList(boardDto));
        // returnData.setPagingInfo(
        //         PagingInfo.builder()
        //             .totalCount(boardService.getBoardListCount(boardDto))
        //             .rowsPerPage(boardDto.getRowsPerPage())
        //             .pageSize(boardDto.getPageSize())
        //             .pageIdx(boardDto.getPageIdx())
        //             .build());

        return ResponseEntity.ok().body(returnData);
    }

//     @PostMapping(value="/api/board/write"
// //            , consumes={MediaType.MULTIPART_FORM_DATA_VALUE
// //                        , MediaType.APPLICATION_JSON_VALUE
// //            }
//     )
//     @ResponseBody
//     public ResponseEntity<?> insertBoard(HttpServletRequest request
//             , @RequestPart(value = "board") String boardString
//             , @RequestPart(value = "files") MultipartFile[] files
//                                          , Model model ) throws Exception {
//         ObjectMapper objectMapper = new ObjectMapper();
//         BoardDto boardDto = objectMapper.readValue(boardString, BoardDto.class);
//         boardDto.setFiles(files);

//         log.debug("test : " + boardDto.toString());

//         boardService.insertBoard(boardDto);



//         ResponseEntity<?> returnData;


//         returnData = ResponseEntity.ok().body("success");
//         return returnData;
//     }


//     @GetMapping("/api/board/view/{idx}")
//     @ResponseBody
//     public ResponseEntity<?> getBoardView(HttpServletRequest request
//                                           , BoardDto boardDto
//                                           , @PathVariable(name = "idx") String idx
//                                           , Model model ) throws Exception {


//         ApiResponse<BoardDto> returnData = new ApiResponse<>();
//         returnData.setBody(boardService.getBoardView(boardDto));

//         return ResponseEntity.ok().body(returnData);
//     }

//     @PostMapping("/api/board/mod")
//     @ResponseBody
//     public ResponseEntity<?> modifyBoard(HttpServletRequest request,
//                                          @RequestBody BoardDto boardDto,
//                                          Model model ) throws Exception {

//         boardService.updateBoard(boardDto);

//         ResponseEntity<?> returnData;


//         returnData = ResponseEntity.ok().body("success");
//         return returnData;
//     }


//     @PostMapping("/api/file/upload")
//     @ResponseBody
//     public ResponseEntity<?> fileUpload(HttpServletRequest request
//             ,@RequestParam(value="file",required = false) MultipartFile file
//             ,Model model ) throws Exception {


//         log.debug("test file : " + file);


//         try {




//         }catch (Exception e){

//         }


//         ResponseEntity<?> returnData;


//         returnData = ResponseEntity.ok().body("success");
//         return returnData;
//     }

}