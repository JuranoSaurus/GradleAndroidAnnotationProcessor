package com.jurano.annotation.compiler;

import com.jurano.annotation.api.FullScreen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class AnnotationProcessor extends AbstractProcessor{

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(FullScreen.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for(Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(FullScreen.class)){
            TypeElement annotatedClass = (TypeElement) annotatedElement;
            // TODO Code generate
            String annotatedClassName = annotatedClass.getSimpleName().toString();

            try {
                FileOutputStream output = new FileOutputStream("E://log.txt");
                output.write(annotatedClassName.getBytes());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;
    }
}
