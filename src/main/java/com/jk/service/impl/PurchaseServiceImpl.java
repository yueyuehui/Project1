package com.jk.service.impl;

import com.jk.dao.PurchaseMapper;

import com.jk.model.UserDTO;
import com.jk.model.Purchase;
import com.jk.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell 7560-1645 on 2017/11/15.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<Purchase> purchaseQuery(Purchase purchase) {
        return purchaseMapper.purchaseQuery(purchase);
    }

    @Override
    public void addGoods(Purchase put) {
        purchaseMapper.addGoods(put);
    }

    @Override
    public List<UserDTO> selectUser() {
        return purchaseMapper.selectUser();
    }
}
