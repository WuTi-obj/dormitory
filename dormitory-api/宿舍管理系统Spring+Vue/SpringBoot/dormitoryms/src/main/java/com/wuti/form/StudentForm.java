package com.wuti.form;

import lombok.Data;

/**
 * @author wuti
 */
@Data
public class StudentForm {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryId;
    private Integer oldDormitoryId;
    private String dormitoryName;
    private String state;
    private String createDate;
}
