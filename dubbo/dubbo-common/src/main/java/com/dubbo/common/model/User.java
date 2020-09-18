package com.dubbo.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-18 15:32
 **/
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private Integer age;
}
