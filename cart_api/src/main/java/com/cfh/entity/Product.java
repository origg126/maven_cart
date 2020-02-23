package com.cfh.entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product implements Serializable {
    private String product_id;
    private String name;
    private Double count;
}
