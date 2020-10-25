package com.weiyi.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        当前类的元信息
     * @param metadataReaderFactory 当前扫描类工厂
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //当前类根路径
        Resource resource = metadataReader.getResource();
        String name = classMetadata.getClassName();
        System.out.println("---》" +name);
        if (name.contains("er")) {
            return true;
        }
        return false;
    }
}
