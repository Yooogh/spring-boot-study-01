package com.zerock.guestbook.service;

import com.zerock.guestbook.dto.GuestbookDto;
import com.zerock.guestbook.dto.PageRequestDto;
import com.zerock.guestbook.dto.PageResultDto;
import com.zerock.guestbook.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDto dto);

    PageResultDto<GuestbookDto, Guestbook> getList(PageRequestDto requestDto);

    default Guestbook dtoToEntity(GuestbookDto dto){
        //dto로 들어오면 entity로 변경
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDto entityToDto(Guestbook entity) {
        GuestbookDto dto = GuestbookDto.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
