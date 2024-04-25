package com.project.resourcesharing.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.project.resourcesharing.model.ItemService;
import com.project.resourcesharing.repository.ItemServiceRepository;

import io.micrometer.common.lang.Nullable;

@Service
public class ItemServiceService {
   
    @Autowired
    ItemServiceRepository itemServiceRepository;

    public Integer addItemService(ItemService itemService)  {

        return itemServiceRepository.addItem(itemService);

    }

    public  List<ItemService>  getAllItemServices()  {

        List<ItemService> itemServices =  itemServiceRepository.getAllItemServices();

        return itemServices;

    }
    

    public  Integer updateService(ItemService service)  {

       return  itemServiceRepository.updateService(service);



    }



}
