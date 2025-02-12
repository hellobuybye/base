package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
// import org.apache.ibatis.type.Alias;

// import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Getter
@Setter
@ToString
@Slf4j
public class BaseDto implements Serializable  {

    private Integer rowsPerPage = 10;
    private Integer page = 1;

    private Integer pageSize = 10;
    private Integer pageCalc;       //페이징에 의한 db 데이터 시작 인덱스값(offset값)

    private String rowNum;

    private String regId;
    private Timestamp regDt;
    private String regDtStr;
    private String modId;
    // private Date modDt;
    private Timestamp modDt;
    private String modDtStr;


    public Integer getPageCalc() {
        setPageCalc( this.rowsPerPage * (this.page - 1) );
        return this.pageCalc;
    }

    public void setRegDt(Timestamp regDt){
        this.regDt = regDt;
        
        LocalDateTime dateTime = regDt.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        
        this.regDtStr = dateTime.format(formatter);

    }

    public void setModDt(Timestamp modDt){
        this.modDt = modDt;
        
        LocalDateTime dateTime = regDt.toLocalDateTime();        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        
        this.modDtStr = dateTime.format(formatter);
    }
    

}
