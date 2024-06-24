package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
// import org.apache.ibatis.type.Alias;




@Getter
@Setter
// @Alias("fileDto")
public class FileDto extends BaseDto {

    private Integer idx;
    private Integer boardIdx;
    private String saveFileNm;
    private String origFileNm;



}
