package com.misty.spring.importmethod.importselect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MistyImportSelector
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 9:55
 * @Version 1.0
 **/
public class MistyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.misty.spring.importmethod.compent.Dog"};
    }
}
