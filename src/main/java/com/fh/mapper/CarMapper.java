package com.fh.mapper;

import com.fh.model.ConditionQuery;
import com.fh.model.Type;
import com.fh.model.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    Long queryCarCount(ConditionQuery conditionQuery);

    List<Car> queryCarList(ConditionQuery conditionQuery);

    void deleteCar(Integer id);

    void addCar(Car car);

    List<Type> queryTypeList();

    Car queryCarById(Integer id);

    void updateCar(Car car);

    List<Type> queryAreaList();
}
