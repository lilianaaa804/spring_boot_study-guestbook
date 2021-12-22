package com.liliana.guestbook.service;

import com.liliana.guestbook.dto.GuestbookDTO;
import com.liliana.guestbook.dto.PageRequestDTO;
import com.liliana.guestbook.dto.PageResultDTO;
import com.liliana.guestbook.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    //기존의 DTO와 엔티티 클래스를 가능하면 변경하지 않도록 하기 위해 default 메서드 이용.
    //추상클래스를 통해 전달해야 하는 실제 코드를 인터페이스에 선언할 수 있다.
    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

    GuestbookDTO read(Long gno);


}
