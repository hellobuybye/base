// package com.cyh.base.controller;

// import com.cyh.base.dto.ApiResponse;
// import com.cyh.base.dto.BoardDto;
// import com.cyh.base.dto.PagingInfo;
// import com.cyh.base.dto.SortDto;
// import com.cyh.base.service.BoardService;
// import com.cyh.base.service.SortService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.multipart.MultipartFile;

// import javax.servlet.http.HttpServletRequest;
// import java.util.List;

// @Controller
// @Slf4j
// public class SortController {

//     @Autowired
//     SortService sortService;

//     @GetMapping("/api/sort/list")
//     @ResponseBody
//     public ResponseEntity<?> getSortList(HttpServletRequest request,
//                                    SortDto sortDto,
//                                    Model model ) throws Exception {


//         ApiResponse<List<SortDto>> returnData = new ApiResponse<>();
//         returnData.setBody(sortService.getSortList(sortDto));


//         return ResponseEntity.ok().body(returnData);
//     }

//     @PostMapping(value="/api/sort/update")
//     @ResponseBody
//     public ResponseEntity<?> updateSort(HttpServletRequest request
//             , @RequestBody SortDto sortDto
//                                          , Model model ) throws Exception {



//         sortService.updateSort(sortDto);



//         ResponseEntity<?> returnData;


//         returnData = ResponseEntity.ok().body("success");
//         return returnData;
//     }



// }