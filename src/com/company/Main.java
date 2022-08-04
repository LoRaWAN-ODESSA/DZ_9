package com.company;

import com.company.service.ShopService;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        shopService.start();
    }


}