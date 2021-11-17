package com.liliana.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDTO<DTO, EN> { //제네릭으로 DTO, EN 타입 지정

    private List<DTO> dtoList;

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }//Page<Entity>타입을 이용해서 생성할 수 있도록 생성자로 작성. Function은 엔티티 객체들을 DTO로 변환해주는 기능.
}
