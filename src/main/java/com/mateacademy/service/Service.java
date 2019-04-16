package com.mateacademy.service;

import com.mateacademy.table.TableX;

import java.util.List;

public interface Service<T extends TableX>{

    T add(T t);

    void delete(Long id);

    T get(Long id);

    void update(T t);

    List<T> getAll();
}
