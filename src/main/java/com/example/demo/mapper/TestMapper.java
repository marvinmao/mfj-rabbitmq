package com.example.demo.mapper;

import com.example.demo.mybatis.beans.Test;

/**
 * Created by IntelliJ IDEA.
 * User: maofujiang
 * Date: 2018/9/29
 */
public interface TestMapper {
    Test selectByPrimaryKey(int id);
}
