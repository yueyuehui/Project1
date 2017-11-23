package com.jk.service;

import com.jk.model.UserDTO;
import com.jk.model.Purchase;

import java.util.List;

/**
 * Created by Dell 7560-1645 on 2017/11/15.
 */
public interface PurchaseService {
    List<Purchase> purchaseQuery(Purchase purchase);

    void addGoods(Purchase put);


    List<UserDTO> selectUser();
}