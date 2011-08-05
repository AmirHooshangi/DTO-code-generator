package com.velorin.annotation.test;

import com.velorin.annotation.DTO;
import com.velorin.parser.JavaBeanParser;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class MyJavaBean {

    @DTO 
    private  int x = 0;
    
    @DTO 
    private double main;

    @DTO 
    JavaBeanParser beanParser;

    @DTO
    public DTO dto;

}
