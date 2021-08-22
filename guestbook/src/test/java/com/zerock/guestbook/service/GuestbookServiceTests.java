package com.zerock.guestbook.service;

import com.zerock.guestbook.dto.GuestbookDto;
import com.zerock.guestbook.dto.PageRequestDto;
import com.zerock.guestbook.dto.PageResultDto;
import com.zerock.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testList(){
        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).build();
        PageResultDto<GuestbookDto, Guestbook> resultDto = service.getList(pageRequestDto);
        for (GuestbookDto guestbookDto : resultDto.getDtoList()) {
            System.out.println(guestbookDto);
        }
    }
}
