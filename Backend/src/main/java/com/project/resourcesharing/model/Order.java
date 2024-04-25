package com.project.resourcesharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String orderId;
    String providerId;
    String customerId;
    String serviceId;
    boolean accepted;
}
