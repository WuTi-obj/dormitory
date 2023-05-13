package com.wuti.vo;

import lombok.Data;

/**
 * @author wuti
 */
@Data
public class AbsentVO {
    private Integer id;
    private String buildingName;
    private String dormitoryName;
    private String studentName;
    private String dormitoryAdminName;
    private String createDate;
    private String reason;
}
