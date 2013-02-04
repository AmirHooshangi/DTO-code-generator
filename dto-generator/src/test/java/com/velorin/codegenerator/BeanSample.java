package com.velorin.codegenerator;

import annoations.DTO;

/**
 * User: Pooya
 * Date: 2/4/13
 * Time: 2:41 PM
 */
public class BeanSample {

    private int i;

    @DTO
    private int j;
    private int k;


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
