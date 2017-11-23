package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.Journal;
import com.jk.model.Procurement;
import com.jk.model.UserBO;
import com.jk.service.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by Microsoft on 2017/11/15.
 */
@RestController
public class ProcurementController extends BaseController {
    @Autowired
    private ProcurementService procurementService;
//boot
    @RequestMapping("/queryEmp")
    public void queryEmp(@RequestParam Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){
        int i = 1;//当前页数
        int n = 10;//每页条数
        int scount = (i-1)*n;
        int ecount = i*n;
        map.put("page", scount);
        map.put("rows", ecount);
        HashMap<String, Object> maps= procurementService.selectInvest(map);

        super.outString(maps.toString(), response);
    }
    //查询  分页 条件查    2
    @RequestMapping("/purchaseQuery1")
    public void purchaseQuery(HttpServletRequest request, String callback, HttpServletResponse response,@RequestParam Map<String,String> map){
        System.out.println("status:" + map );
        List<Procurement> purchaseList=procurementService.purchaseQuery(map);
        String json = JSON.toJSONStringWithDateFormat(purchaseList, "yyyy-MM-dd HH:mm:ss");
        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);
    }


    //easyui查询
    @RequestMapping("/shows")
    public void jourList(Integer page,Integer rows,String callback,HttpServletRequest request,HttpServletResponse response){
        System.out.println(page);
        List<Procurement> jourList = procurementService.procurementList();

        String json = JSON.toJSONStringWithDateFormat(jourList, "yyyy-MM-dd HH:mm:ss");
        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);

    }

}

