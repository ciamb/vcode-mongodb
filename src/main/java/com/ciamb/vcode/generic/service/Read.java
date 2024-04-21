package com.ciamb.vcode.generic.service;

import java.util.List;

public interface Read<T> {

    T readBy(long id);

    List<T> readAll();
}
