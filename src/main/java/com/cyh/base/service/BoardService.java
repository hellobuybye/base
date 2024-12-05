package com.cyh.base.service;

import com.cyh.base.dto.BoardDto;
import com.cyh.base.dto.FileDto;
import com.cyh.base.mapper.BoardMapper;

// import com.cyh.base.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// @RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // @Autowired
    // private FileMapper fileMapper;

    public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception  {

        if (boardDto.getRowsPerPage() < 1) {
            throw new Exception();
        }
        if (boardDto.getPage() < 1) {
            throw new Exception();
        }

        return boardMapper.getBoardList(boardDto);

    }

    public Integer getBoardListCount(BoardDto boardDto) throws Exception  {

        return boardMapper.getBoardListCount(boardDto);

    }

//     @Transactional
//     public void insertBoard(BoardDto boardDto) throws Exception  {

//         boardMapper.insertBoard(boardDto);

//         for(MultipartFile file : boardDto.getFiles()) {
//             if (!file.isEmpty()) {
//                 String originalFileName = file.getOriginalFilename();

// //                long saveFileNm = new Random(System.currentTimeMillis()).nextLong();
// //                saveFileNm = saveFileNm == Long.MIN_VALUE ? 0 : saveFileNm;
// //                saveFileNm = Math.abs(saveFileNm);
//                 UUID uuid = UUID.randomUUID();
//                 String saveFileNm = uuid.toString();

//                 FileDto fileDto = new FileDto();
//                 fileDto.setBoardIdx(boardDto.getIdx());
//                 fileDto.setOrigFileNm(originalFileName);
//                 fileDto.setSaveFileNm(saveFileNm);
//                 fileMapper.insertFile(fileDto);

//                 File destination = new File("D:/upload/" + saveFileNm);

//                 file.transferTo(destination);

//             }
//         }

//     }

//     public BoardDto getBoardView(BoardDto boardDto) throws Exception  {

//         BoardDto board = boardMapper.getBoardView(boardDto);

//         FileDto fileDto = new FileDto();
//         fileDto.setBoardIdx(board.getIdx());
//         board.setFileList(fileMapper.getFileList(fileDto));

//         return board;

//     }

//     public void updateBoard(BoardDto boardDto) throws Exception  {

//         boardMapper.updateBoard(boardDto);

//         for(MultipartFile file : boardDto.getFiles()) {
//             if (!file.isEmpty()) {
//                 String originalFileName = file.getOriginalFilename();

// //                long saveFileNm = new Random(System.currentTimeMillis()).nextLong();
// //                saveFileNm = saveFileNm == Long.MIN_VALUE ? 0 : saveFileNm;
// //                saveFileNm = Math.abs(saveFileNm);
//                 UUID uuid = UUID.randomUUID();
//                 String saveFileNm = uuid.toString();

//                 FileDto fileDto = new FileDto();
//                 fileDto.setBoardIdx(boardDto.getIdx());
//                 fileDto.setOrigFileNm(originalFileName);
//                 fileDto.setSaveFileNm(saveFileNm);
//                 fileMapper.insertFile(fileDto);

//                 File destination = new File("D:/upload/" + saveFileNm);

//                 file.transferTo(destination);

//             }
//         }

//     }

}
