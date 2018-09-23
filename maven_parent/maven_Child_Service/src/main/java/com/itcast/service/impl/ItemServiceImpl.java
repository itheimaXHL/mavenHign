package com.itcast.service.impl;

import com.itcast.dao.ItemsDao;
import com.itcast.pojo.Items;
import com.itcast.pojo.ItemsExample;
import com.itcast.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsDao itemsDao;






    public Items findByid(int id) {
        return itemsDao.selectByPrimaryKey(id);
    }

    public void updateById(Items items) {
        itemsDao.updateByPrimaryKey(items);
    }

    public void deleteById(int id) {
        itemsDao.deleteByPrimaryKey(id);
    }

    public List<Items> findAll() {
        return itemsDao.findAll();
    }

    public Items findByName(String name) {
        return itemsDao.findByName(name);
    }

    @Override
    public void saveItems(Items items) {
        itemsDao.insert(items);
    }
}
