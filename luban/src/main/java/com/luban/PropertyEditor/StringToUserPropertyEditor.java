package com.luban.PropertyEditor;

import com.luban.entity.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Author: xingbinjie
 * @Desc:
 * @Version: 0.0.1
 * @Date: 2021/2/12
 */
public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		user.setName(text);
		this.setValue(user);
	}

}