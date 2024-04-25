package com.project.resourcesharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemService {
    String serviceId;
    String userId;
    String item_service;
    Float price;
    boolean active;
}
