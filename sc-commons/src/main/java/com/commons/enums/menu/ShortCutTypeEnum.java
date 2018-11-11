package com.commons.enums.menu;

/**
 * @Description(功能描述): 菜单类型
 * @author(作者): panpengfei
 * @email panpf@talust.org
 * @date(开发日期): 2018/9/4 19:58
 **/
public enum ShortCutTypeEnum {
    ENTERPRISE(1,"企业菜单"),
    PERSONAL(2,"个人菜单");

    private int code;

    private String name;

    ShortCutTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}
