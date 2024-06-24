// package com.example.practice.service;

// import com.example.practice.dto.BoardDto;
// import com.example.practice.dto.FileDto;
// import com.example.practice.dto.MenuDto;
// import com.example.practice.mapper.BoardMapper;
// import com.example.practice.mapper.FileMapper;
// import com.example.practice.mapper.MenuMapper;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.File;
// import java.util.List;
// import java.util.UUID;

// @RequiredArgsConstructor
// @Service
// @Slf4j
// public class MenuService {

//     @Autowired
//     private MenuMapper menuMapper;

//     public List<MenuDto> getMenuList(MenuDto menuDto) throws Exception  {

//         return menuMapper.getMenuList(menuDto);

//     }

//     public List<MenuDto> getMenuMngList(MenuDto menuDto) throws Exception  {

//         return menuMapper.getMenuMngList(menuDto);

//     }

//     public MenuDto getMenuDetail(MenuDto menuDto) throws Exception  {

//         return menuMapper.getMenuDetail(menuDto);

//     }

//     public void insertMenu(MenuDto menuDto) throws Exception  {

//         menuMapper.insertMenu(menuDto);

//     }

//     public void updateMenu(MenuDto menuDto) throws Exception  {

//         menuMapper.updateMenu(menuDto);
// //        menuMapper.updateReSort(menuDto);

//     }

// }
