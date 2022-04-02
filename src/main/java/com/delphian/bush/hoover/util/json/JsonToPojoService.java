package com.delphian.bush.hoover.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public abstract class JsonToPojoService<T> {

    private final ObjectMapper objectMapper;
    private final File file;
    private final Class<T> targetClass;

    protected JsonToPojoService(File file, ObjectMapper objectMapper, Class<T> targetClass) {
        this.objectMapper = objectMapper;
        this.file = file;
        this.targetClass = targetClass;
    }

    public T getFromJson() {
        try {
            return objectMapper.readValue(file, targetClass);
        } catch (IOException e) {
            log.debug("Json test service encountered unexpected exception: {}", e.getMessage());
            return null;
        }
    }

}
