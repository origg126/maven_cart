package com.cfh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/23 13:46
 */
 @Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Cart{
    private String id;
    private String name;
    private Double price;
    private Integer count;
}
