package com.svetikov.storage2020.service;

import java.util.List;

public interface ModelService<T,ID> {
    T saveModel(T t);

    T getModelBuID(ID id);

    List<T> getAllModel();

    T deleteModel(ID id);

}
