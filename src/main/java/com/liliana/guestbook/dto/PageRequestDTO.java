package com.liliana.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    //Pageable타입의 객체 생성 목적
    //page, size 파라미터 수집
    private int page;
    private int size;

    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;//페이지 번호는 기본값
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);
    }

}
