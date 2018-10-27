package com.plm.form;

import lombok.Data;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 1:05
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
