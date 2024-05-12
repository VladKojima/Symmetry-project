package com.jwt.service.dto;

import lombok.Data;

@Data
public class ExpirationTime {

    private Long day;

    private Long hour;

    private Long minute;

    private Long second;

}
