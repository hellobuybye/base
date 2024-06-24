package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// import org.apache.ibatis.type.Alias;


@Getter
@Setter
@ToString
// @Alias("menuDto")
public class MenuDto extends BaseDto {

    private Integer idx;
    private Integer pIdx;
    private String title;
    private String pathUrl;
    private Integer sortOrder;
    private String icon;
    private String useYn;



}
