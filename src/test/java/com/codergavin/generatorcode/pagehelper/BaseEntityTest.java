package com.codergavin.generatorcode.pagehelper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gavin Lee
 * @version 1.0
 * @date 2020/11/17 0017 18:14
 * @desc
 */
class BaseEntityTest {

    @Test
    void getOrderByStr() {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setOrderBy("caseId");
        System.out.println(baseEntity.getOrderByStr());
    }
}