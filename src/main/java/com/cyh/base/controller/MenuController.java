// package com.cyh.base.controller;

// import com.cyh.base.dto.ApiResponse;
// import com.cyh.base.dto.BoardDto;
// import com.cyh.base.dto.MenuDto;
// import com.cyh.base.dto.PagingInfo;
// import com.cyh.base.service.BoardService;
// import com.cyh.base.service.MenuService;
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
// public class MenuController {

//     @Autowired
//     MenuService menuService;

//     @GetMapping("/api/menu/list")
//     @ResponseBody
//     public ResponseEntity<?> getMenuList(HttpServletRequest request,
//                                    MenuDto menuDto,
//                                    Model model ) throws Exception {


//         ApiResponse<List<MenuDto>> returnData = new ApiResponse<>();
//         returnData.setBody(menuService.getMenuList(menuDto));

//         return ResponseEntity.ok().body(returnData);
//     }

//     @GetMapping("/api/menu/mng/list")
//     @ResponseBody
//     public ResponseEntity<?> getMenuMngList(HttpServletRequest request,
//                                          MenuDto menuDto,
//                                          Model model ) throws Exception {


//         ApiResponse<List<MenuDto>> returnData = new ApiResponse<>();
//         returnData.setBody(menuService.getMenuMngList(menuDto));

//         return ResponseEntity.ok().body(returnData);
//     }

//     @PostMapping("/api/menu/mng/add")
//     @ResponseBody
//     public ResponseEntity<?> insertMenu(HttpServletRequest request,
//                                             @RequestBody MenuDto menuDto,
//                                             Model model ) throws Exception {

//         menuService.insertMenu(menuDto);

//         ApiResponse<List<MenuDto>> returnData = new ApiResponse<>();


//         return ResponseEntity.ok().body(returnData);
//     }



// }