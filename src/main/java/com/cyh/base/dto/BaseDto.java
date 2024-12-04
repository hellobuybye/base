package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
// import org.apache.ibatis.type.Alias;

// import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@Slf4j
public class BaseDto implements Serializable  {

    private Integer rowsPerPage = 10;
    private Integer pageIdx = 1;

    private Integer pageSize = 10;
    private Integer pageCalc;       //페이징에 의한 db 데이터 시작 인덱스값

    private String regId;
    // private Date regDt;
    private String regDt;
    private String modId;
    private Date modDt;


    public Integer getPageCalc() {
        setPageCalc( this.rowsPerPage * this.pageIdx );
        return this.pageCalc;
    }

}
