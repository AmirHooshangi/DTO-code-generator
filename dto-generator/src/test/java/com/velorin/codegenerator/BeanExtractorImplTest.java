package com.velorin.codegenerator;

import org.junit.Test;

/**
 * User: Pooya
 * Email: info@pooya-hfp.ir
 * Date: 2/4/13
 * Time: 4:44 PM
 */
public class BeanExtractorImplTest {
    @Test
    public void testGenerateDtoFromBean() throws Exception {
        BeanConverter beanExtractor = new DtoGenerator();
        beanExtractor.generateDtoFromBean(BeanSample.class, "PPP", "FILEPATH.java");
    }

    @Test
    public void testGenerateBeanFromDto() throws Exception {
        BeanConverter beanExtractor = new DtoGenerator();
        beanExtractor.generateDtoFromBean("com.velorin.codegenerator", "PPP", "FILEPATH.java");
    }
}
