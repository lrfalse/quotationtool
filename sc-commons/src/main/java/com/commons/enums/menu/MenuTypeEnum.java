package com.commons.enums.menu;

/**
 * @Description(功能描述): 菜单是按钮还是控件
 * @author(作者): panpengfei
 * @email panpf@talust.org
 * @date(开发日期): 2018/9/4 18:38
 **/
public enum MenuTypeEnum {
    MENU(1,"菜单"),
    CONTROL(2,"控件");

    private int code;

    private String name;

    MenuTypeEnum(int code, String name) {
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
