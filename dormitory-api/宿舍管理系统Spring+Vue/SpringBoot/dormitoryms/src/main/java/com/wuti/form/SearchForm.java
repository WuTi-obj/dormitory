package com.wuti.form;

import lombok.Data;

/**
 * @author wuti
 */

@Data
public class SearchForm {
    private String key;
    private String value;
    private Integer page;
    private Integer size;
}
