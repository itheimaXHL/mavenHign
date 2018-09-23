package com.itcast.controller;


import com.itcast.pojo.Items;
import com.itcast.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/items")
public class TestController {

    @Autowired
    private ItemService itemService;

    private static final String FINDALL="redirect:/items/findAll";

    @RequestMapping("/findAll")
    public  ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Items> items = itemService.findAll();
        mv.addObject("items", items);
        mv.setViewName("success");
        return mv;
    }



    @RequestMapping("/findById")
    public  ModelAndView findById(int id) {
        ModelAndView mv = new ModelAndView();
        Items item = itemService.findByid(id);
        mv.addObject("item", item);
        mv.setViewName("update");
        return mv;
    }


    @RequestMapping("/delete")
    public  String deleteById(int id) {
        itemService.deleteById(id);
        return FINDALL;
    }

    @RequestMapping("/update")
    public  String updateById(Items items) {
        itemService.updateById(items);
        return FINDALL;
    }

    @RequestMapping("/saveItems")
    public  String saveItems(Items items, HttpServletRequest request) {
        String name = items.getName();
        Items list = itemService.findByName(name);
        if (list==null){
            itemService.saveItems(items);
            return FINDALL;
        }else {
            request.setAttribute("item",items);
            request.removeAttribute("item");
            request.setAttribute("error","名字已存在");
            return  "forward:/insert.html";
        }

    }

    @RequestMapping("/findAllAjax")
    public  @ResponseBody List<Items> findAllAjax() {
        return itemService.findAll();
    }

    @RequestMapping("/deleteAjax")
    public  String deleteAjax(int id) {
        itemService.deleteById(id);
        return "redirect:/success.html";
    }

    @RequestMapping("/updateAjax")
    public  @ResponseBody Items  updateAjax(Items items) {
        itemService.updateById(items);
        return items;
    }

    @RequestMapping("/findByIdAjax")
    public  @ResponseBody Items findByIdAjax(int id) {
        return itemService.findByid(id);
    }

    @RequestMapping("/saveItemsAjax")
    public  @ResponseBody Items saveItemsAjax(Items items) throws IOException {
        String name = items.getName();
        Items list = itemService.findByName(name);
        if (list==null||list.equals("")){
            itemService.saveItems(items);
        }else {
            items.setPic("名字已存在");
        }
        return items;
    }

}
