package com.db.nace.util;

import com.db.nace.dto.NaceDto;
import com.db.nace.entity.Nace;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NaceUtils {

    public List<Nace> convertToEntity(List<NaceDto> dtoList) {

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return dtoList.stream().map(
                dto -> {
                    Nace nace = new Nace();

                    try {
                        nace.setOrderNum(decimalFormat.parse(dto.getOrderNum()).longValue());
                        nace.setLevel(decimalFormat.parse(dto.getLevel()).longValue());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    nace.setParent(dto.getParent());
                    nace.setCode(dto.getCode());
                    nace.setDescription(dto.getDescription());
                    nace.setItemIncludes(dto.getItemIncludes());
                    nace.setItemAlsoIncludes(dto.getItemAlsoIncludes());
                    nace.setItemExcludes(dto.getItemExcludes());
                    nace.setReference(dto.getReference());
                    return nace;
                }
        ).collect(Collectors.toList());
    }

    public NaceDto convertToDto(Nace naceEntity) {

        NaceDto naceDto = new NaceDto();
        naceDto.setOrderNum(String.valueOf(naceEntity.getOrderNum()));
        naceDto.setLevel(String.valueOf(naceEntity.getLevel()));
        naceDto.setParent(naceEntity.getParent());
        naceDto.setCode(naceEntity.getCode());
        naceDto.setDescription(naceEntity.getDescription());
        naceDto.setItemIncludes(naceEntity.getItemIncludes());
        naceDto.setItemAlsoIncludes(naceEntity.getItemAlsoIncludes());
        naceDto.setItemExcludes(naceEntity.getItemExcludes());
        naceDto.setReference(naceEntity.getReference());

        return naceDto;
    }
}
