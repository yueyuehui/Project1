package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.Journal;
import com.jk.model.MenuTree;
import com.jk.model.Power;
import com.jk.service.TreeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;


/**
 * Created by Mr.wangbin on 2017/11/14.
 */
@RestController
public class TreeController extends BaseController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("/findJ")
    public void jourList(Integer page,Integer rows,String callback,HttpServletRequest request,HttpServletResponse response){
            System.out.println(page);
        List<Journal> jourList = treeService.jourList();

        String json = JSON.toJSONStringWithDateFormat(jourList, "yyyy-MM-dd HH:mm:ss");
        //加上返回参数
        json=callback+"("+json+")";
        super.outString(json, response);

    }


    @RequestMapping("/getTree")
    public List<Power> tree(){
        List<Power> treelist = treeService.treelist();

        return treelist;
    }

    @RequestMapping("/tree2")
    public List<Power> tree(HttpServletRequest request, HttpServletResponse response){

        List<Power> treelist = treeService.treelist();

           return treelist;


    }
    @RequestMapping("/tree")
    public void treeList(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Power> treelist = treeService.treelist();
            response.setContentType("text/plain");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
          //  Map<String,Object> map = new HashMap<String,Object>();
           // map.put("result", treelist);
            PrintWriter out = response.getWriter();
            JSONObject resultJSON = JSONObject.fromObject(treelist); //根据需要拼装json
            String jsonStr = resultJSON.toString();
            String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数
            out.println(jsonpCallback+jsonStr);//返回jsonp格式数据
            out.flush();
            out.close();

            //response.getWriter().write("11");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
