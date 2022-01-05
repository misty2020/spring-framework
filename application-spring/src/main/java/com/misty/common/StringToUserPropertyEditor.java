package com.misty.common;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @ClassName StringToUserPropertyEditor
 * @Description 转换器
 * @Author HeTao
 * @Date 2022/1/5 15:09
 * @Version 1.0
 **/
public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        user.setName(text);
        this.setValue(user);
    }
}
