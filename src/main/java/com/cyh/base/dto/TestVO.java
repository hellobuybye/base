package com.cyh.base.dto;

import com.cyh.base.validate.SampleValidates;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class TestVO {

    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 1")
    private String name;
    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 22")
    private String text;

}
