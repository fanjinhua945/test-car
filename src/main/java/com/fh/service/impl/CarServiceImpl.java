package com.fh.service.impl;

import com.fh.mapper.CarMapper;
import com.fh.model.*;
import com.fh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public DataTableResult queryCarList(ConditionQuery conditionQuery) {
        //1.查询总条数
        Long count = carMapper.queryCarCount(conditionQuery);
        //2.查询当前页数据
        List<Car> carList = carMapper.queryCarList(conditionQuery);
        DataTableResult dataTableResult = new DataTableResult(conditionQuery.getDraw(),count,count,carList);
        return dataTableResult;
    }

    @Override
    public List<Type> queryTypeList() {
        return carMapper.queryTypeList();
    }

    @Override
    public void deleteCar(Integer id) {
        carMapper.deleteCar(id);
    }

    @Override
    public void addCar(Car car) {
        car.setCreateDate(new Date());
        carMapper.addCar(car);
    }

    @Override
    public Car queryCarById(Integer id) {
        return carMapper.queryCarById(id);
    }

    @Override
    public void updateCar(Car car) {
        car.setUpdateDate(new Date());
        carMapper.updateCar(car);
    }

    @Override
    public List<Type> queryAreaList() {
        return carMapper.queryAreaList();
    }
}
