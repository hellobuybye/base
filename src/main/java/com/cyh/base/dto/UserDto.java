package com.cyh.base.dto;

import com.cyh.base.validate.SampleValidates;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class UserDto {

    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 1")
    private String userId;
    // @NotEmpty(groups = SampleValidates.Group1.class, message = "test message 22")
    private String password;

    

}
