package com.liliana.guestbook.service;

import com.liliana.guestbook.dto.GuestbookDTO;
import com.liliana.guestbook.entity.Guestbook;
import com.liliana.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO---------------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);//등록된 dto 엔티티로 변환
        log.info(entity);

        guestbookRepository.save(entity);

        return entity.getGno();
    }
}
