// package com.cyh.base.service;

// import com.cyh.base.dto.BoardDto;
// import com.cyh.base.dto.FileDto;
// import com.cyh.base.dto.SortDto;
// import com.cyh.base.mapper.BoardMapper;
// import com.cyh.base.mapper.FileMapper;
// import com.cyh.base.mapper.SortMapper;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.File;
// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.List;
// import java.util.UUID;
// import java.util.stream.Collectors;

// @RequiredArgsConstructor
// @Service
// @Slf4j
// public class SortService {

//     @Autowired
//     private SortMapper sortMapper;


//     public List<SortDto> getSortList(SortDto sortDto) throws Exception  {

//         if (sortDto.getRowsPerPage() < 1) {
//             throw new Exception();
//         }
//         if (sortDto.getPageIdx() < 1) {
//             throw new Exception();
//         }

//         return sortMapper.getSortList(sortDto);

//     }



//     @Transactional
//     public void updateSort(SortDto sortDto) throws Exception {

//         sortMapper.updateSort(sortDto);
//         sortMapper.updateReSort(sortDto);

//     }



// }
