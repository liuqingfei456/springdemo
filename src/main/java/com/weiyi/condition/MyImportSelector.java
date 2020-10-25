package com.weiyi.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(importingClassMetadata);
        return new String[]{"com.weiyi.pojo.Blue"};
    }


}
