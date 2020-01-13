package com.fh.controller;


import com.fh.model.*;
import com.fh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("CarController")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    //查询
    @PostMapping("queryCarList")
    //ConditionQuery继承了DataTablePageBean的分页功能。
    public DataTableResult queryCarList(@RequestBody ConditionQuery conditionQuery){
        //调用CarService的queryCarList方法，另附分页和条件查询的参数
        DataTableResult dataTableResult = carService.queryCarList(conditionQuery);
        return dataTableResult;
    }

    @RequestMapping("queryTypeList")
    public Map<String, Object> queryTypeList(){
        Map<String, Object> result = new HashMap<>();
        try {
            List<Type> typeList = carService.queryTypeList();
            result.put("code",200);
            result.put("data",typeList);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("queryAreaList")
    public Map<String, Object> queryAreaList(){
        Map<String, Object> result = new HashMap<>();
        try {
            List<Type> areaList = carService.queryAreaList();
            result.put("code",200);
            result.put("data",areaList);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("deleteCar/{id}")
    public Map<String, Object> deleteCar(@PathVariable("id") Integer id){
        Map<String, Object> result = new HashMap<>();
        try {
            carService.deleteCar(id);
            result.put("code",200);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

    //新增用户
    @PostMapping("addCar")
    public Map<String,Object> addCar(@RequestBody Car car){
        Map<String,Object> result = new HashMap();
        try {
            carService.addCar(car);
            result.put("code",200);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("queryCarById")
    public Map<String,Object> queryCarById(Integer id){
        Map<String,Object> result = new HashMap<>();
        try {
            Car car = carService.queryCarById(id);
            result.put("data",car);
            result.put("code",200);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("updateCar")
    public Map<String,Object>updateCar(@RequestBody Car car){
        Map<String,Object> result = new HashMap<>();
        try {
            carService.updateCar(car);
            result.put("code",200);
        } catch (Exception e) {
            result.put("code",500);
            e.printStackTrace();
        }
        return result;
    }

}
