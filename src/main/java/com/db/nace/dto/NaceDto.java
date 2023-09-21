package com.db.nace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class NaceDto {

    private  String orderNum;
    private String level;
    private String code;
    private String parent;
    private String description;
    private String itemIncludes;
    private String itemAlsoIncludes;
    private String itemExcludes;
    private String reference;
}
