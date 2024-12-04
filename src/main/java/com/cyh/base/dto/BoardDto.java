package com.cyh.base.dto;

import lombok.Getter;
import lombok.Setter;
// import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

// import javax.validation.constraints.NotEmpty;
import java.util.List;


@Getter
@Setter
// @Alias("boardDto")
public class BoardDto extends BaseDto {

    private Integer idx;
    // @NotEmpty/*(groups = SampleValidates.Group1.class, message = "test message 1")*/
    private String code;
    // @NotEmpty/*(groups = SampleValidates.Group1.class, message = "test message 22")*/
    private String subject;
    private String content;

    private MultipartFile[] files;
    private List<FileDto> fileList;

    private String keyword;

}
