package com.plm.utils;

import com.plm.enums.CodeEnum;

/**
 * chenwenhua
 * 2018\10\25 0025
 * 20:47
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
