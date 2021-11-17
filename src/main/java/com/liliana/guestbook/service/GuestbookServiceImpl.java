package com.liliana.guestbook.service;

import com.liliana.guestbook.dto.GuestbookDTO;
import com.liliana.guestbook.dto.PageRequestDTO;
import com.liliana.guestbook.dto.PageResultDTO;
import com.liliana.guestbook.entity.Guestbook;
import com.liliana.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = guestbookRepository.findAll(pageable);
        //entityToDto()를 이용해서 java.util.Function을 생성하고 PageResultDTO로 구성
        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);

    }

    @Override
    public Guestbook dtoToEntity(GuestbookDTO dto) {
        return null;
    }
}
