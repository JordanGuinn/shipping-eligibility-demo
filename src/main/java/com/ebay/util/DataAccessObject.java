package com.ebay.util;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataAccessObject<T> {

    T get(Long id);

    List<T> list();

    void create(T t);

    void update(T t);

    void delete(Long id);
}
