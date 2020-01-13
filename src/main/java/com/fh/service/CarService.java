package com.fh.service;

import com.fh.model.*;

import java.util.List;

public interface CarService {
    DataTableResult queryCarList(ConditionQuery conditionQuery);

    void deleteCar(Integer id);

    void addCar(Car car);

    List<Type> queryTypeList();

    Car queryCarById(Integer id);

    void updateCar(Car car);

    List<Type> queryAreaList();
}
