package com.itcast.service;

import com.itcast.pojo.Items;

import java.util.List;

public interface ItemService {

    Items findByid(int id);

    Items findByName(String name);

    void updateById(Items items);

    void deleteById(int id);

    List<Items> findAll();

    void saveItems(Items items);
}
