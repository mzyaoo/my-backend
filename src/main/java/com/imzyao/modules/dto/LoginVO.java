package com.imzyao.modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginVO {

    private String token;

    private String tokenHeader;

    private String requestHeaderKey;

}
