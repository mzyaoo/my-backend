package com.imzyao.modules.dto.role;

import com.imzyao.modules.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRoleTableParam extends PageRequest {

    private String roleName;

    private Integer status;

    private String createTimeStart;

    private String createTimeEnd;

}
