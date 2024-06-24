// package com.cyh.base.controller;

// import com.cyh.base.dto.ApiResponse;
// import com.cyh.base.dto.BoardDto;
// import com.cyh.base.dto.FileDto;
// import com.cyh.base.dto.PagingInfo;
// import com.cyh.base.service.BoardService;
// import com.cyh.base.service.FileService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.FileCopyUtils;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.ModelAndView;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.OutputStream;
// import java.util.List;

// @Controller
// @Slf4j
// public class FileController {

//     @Autowired
//     FileService fileService;

//     @GetMapping("/file/{fileNm}")
//     @ResponseBody
//     public void getFileInfo(HttpServletRequest request
//                                     ,HttpServletResponse response
//             , @PathVariable(name = "fileNm") String fileNm
//             , Model model ) throws Exception {


//         File file = new File("D:/upload/",fileNm);

// //        response.setContentType("application/download");
// //        response.setContentLength((int)file.length());
// //        response.setHeader("Content-disposition", "attachment;filename=\"" + fileNm + "\"");

//         // response 객체를 통해서 서버로부터 파일 다운로드
//         OutputStream os = response.getOutputStream();
//         // 파일 입력 객체 생성
//         FileInputStream fis = new FileInputStream(file);
//         FileCopyUtils.copy(fis, os);
//         fis.close();
//         os.close();

//     }


// }