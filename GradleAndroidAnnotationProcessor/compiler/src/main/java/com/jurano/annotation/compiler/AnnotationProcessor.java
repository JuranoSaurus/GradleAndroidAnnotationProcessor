package com.jurano.annotation.compiler;

import com.jurano.annotation.api.FullScreen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class AnnotationProcessor extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for(Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(FullScreen.class)){
            TypeElement annotatedClass = (TypeElement) annotatedElement;
            // TODO Code generate
            String annotatedClassName = annotatedClass.getSimpleName().toString();

            try {
                FileOutputStream output = new FileOutputStream("D:\\log.txt");
                output.write(annotatedClassName.getBytes());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;
    }
}
