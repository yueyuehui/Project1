package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.Purchase;
import com.jk.model.UserDTO;
import com.jk.service.PurchaseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Dell 7560-1645 on 2017/11/15.
 */
@RestController
public class PurchaseController extends  BaseController{

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/purchaseQuery")
    public void purchaseQuery(HttpServletRequest request, String callback, HttpServletResponse response,Purchase purchase){
            System.out.println("status:" + purchase );
        List<Purchase> purchaseList=purchaseService.purchaseQuery(purchase);

        String json = JSON.toJSONStringWithDateFormat(purchaseList, "yyyy-MM-dd HH:mm:ss");

        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);
    }

    @RequestMapping("/addGoods")
    public void goodsAdd(Purchase purchase,String callback,HttpServletRequest request){
        System.out.println("put:" + purchase );
        purchaseService.addGoods(purchase);
    }

    @RequestMapping("/selectUser")
    public void selectUser( HttpServletRequest request, HttpServletResponse response){
        List<UserDTO> list = purchaseService.selectUser();
        String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
        String jsonpCallback = request.getParameter("callback");//客户端请求参数
        super.outString(jsonpCallback+"("+json+")",response);
    }
}
