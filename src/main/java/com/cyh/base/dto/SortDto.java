package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@Getter
@Setter
@ToString
// @Alias("sortDto")
public class SortDto extends BaseDto {

    private Integer idx;
    private Integer ordd;
    private String text;

    private Integer newOrdd;

}
