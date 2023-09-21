package com.db.nace.util;

import com.db.nace.dto.NaceDto;
import com.db.nace.entity.Nace;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NaceUtilsTest {

    NaceUtils naceUtils= new NaceUtils();
    @Test
    void convertToEntity() {
        List<Nace> naceList = naceUtils.convertToEntity(Arrays.asList((getNaceDto())));
        assertEquals(1,naceList.size());
        assertEquals(1111,naceList.get(0).getOrderNum());
        assertEquals(111,naceList.get(0).getLevel());
        assertEquals("desc",naceList.get(0).getDescription());
    }

    @Test
    void convertToDto() {

        NaceDto naceDto = naceUtils.convertToDto(getNace());

        assertEquals("111", naceDto.getOrderNum());
        assertEquals("111", naceDto.getLevel());
        assertEquals("desc", naceDto.getDescription());
    }

    private NaceDto getNaceDto(){
        NaceDto naceDto = new NaceDto();
        naceDto.setOrderNum("1111");
        naceDto.setLevel("111");
        naceDto.setCode("a");
        naceDto.setParent("a");
        naceDto.setDescription("desc");
        return  naceDto;
    }

    private Nace getNace(){
        Nace nace = new Nace();
        nace.setId(1L);
        nace.setOrderNum(111L);
        nace.setLevel(111L);
        nace.setDescription("desc");
        return nace;
    }
}