package com.cyh.base.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PagingInfo implements Serializable {
	private static final long serialVersionUID = 6267086554698703911L;

	private int totalCount;		// 총 데이터 갯수
	private int rowsPerPage;	// 페이지당 데이터 갯수
	private int page;		// 페이지 번호
	private int pageSize;		// 페이징 크기
	private int pageCalc;

	private int startPage;		// 페이징 사이즈에 맞는 시작지점
	private int endPage;		// 페이징 사이즈에 맞는 종료지점

	private int finalPage;		// 마지막페이지




	public Integer getStartPage() {

		if( this.page - Math.floor(this.pageSize/2) > 1){
			setStartPage( this.page - (int)Math.floor(this.pageSize/2) );


			if( this.page + Math.ceil( (double)this.pageSize/2) >= this.getFinalPage() ){
				//오른쪽 끝에 도달 했을 경우

				if(this.getFinalPage() - this.pageSize >= 1){
					setStartPage(this.getFinalPage() -  this.pageSize ) ;
				}else{
					setStartPage(1);
				}

			}

		}else{
			setStartPage(1);
		}

		return this.startPage;
	}

	public Integer getEndPage() {

		if( this.page + Math.ceil( (double)this.pageSize/2)  - 1 <= this.getFinalPage() ){
			setEndPage(  (this.page + (int)Math.ceil( (double)this.pageSize/2) - 1   ) );

			if( this.page - Math.floor( (double)this.pageSize/2) < 1 ){
				//왼쪽 끝에 도달했을 경우

				if( 1 + this.pageSize <= this.getFinalPage()){
					setEndPage( 1 +  this.pageSize - 1 ) ;
				}else{
					setEndPage(getFinalPage());
				}

			}

		}else{
			setEndPage(getFinalPage());
		}

		return this.endPage;
	}
	public Integer getFinalPage() {

		setFinalPage((int) Math.ceil( (double) this.totalCount / this.rowsPerPage ) );

		return this.finalPage;
	}


}
