package com.project.resourcesharing.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.resourcesharing.model.ItemService;

import io.micrometer.common.lang.Nullable;

@Repository
public class ItemServiceRepository {
  
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addItem(ItemService itemService) {
        System.out.println("inside itemService");
        String sql = "INSERT INTO ServiceTable (userId, item_service, price, active) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
        itemService.getUserId(),
        itemService.getItem_service(),
        itemService.getPrice(), 
        itemService.isActive());
    }
    public List<ItemService> getAllItemServices() {

        String sql = "Select * from  ServiceTable";


        return jdbcTemplate.query(sql, new RowMapper<ItemService>() {

            @Override
            @Nullable
            public ItemService mapRow(ResultSet rs, int rowNum) throws SQLException {
                ItemService c = new ItemService();


                c.setUserId(rs.getString("userId"));
                c.setItem_service(rs.getString("item_service"));
                c.setPrice(Float.parseFloat(rs.getString("price")));
                c.setActive(Boolean.parseBoolean(rs.getString("active")));
                    return c;
            }
            
        });
    }


    public Integer updateService(ItemService service){
        String sql = "UPDATE ServiceTable SET "
                   + "userId = ?, "
                   + "item_service = ?, "
                   + "price = ?, "
                   + "active = ? "
                   + "WHERE serviceId = ?";

        return jdbcTemplate.update(sql, 
        service.getUserId(), 
        service.getItem_service(), 
        service.getPrice(),
        service.isActive(), 
        service.getServiceId());
    }
    

}
