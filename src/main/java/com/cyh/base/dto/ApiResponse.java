package com.cyh.base.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse<T> implements Serializable {
	private static final long serialVersionUID = -2438014012950414283L;

//	private String code;
//    private String message;

    private T body;

    private PagingInfo pagingInfo;


}
