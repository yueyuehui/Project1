package com.jk.controller;


import com.jk.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SysTemController extends BaseController {

	@Autowired
	private SystemService systemService;

	/**
	 * 获取树节点数据
	 * <pre>queryTree(作用：)   
	 * 创建人：李岳         
	 * 创建时间：2017年9月4日 上午9:13:38    
	 * 修改人：李岳       
	 * 修改时间：2017年9月4日 上午9:13:38    
	 * 修改备注： </pre>
	 */
	@RequestMapping("/btree")
	public void queryTree(HttpServletRequest request,String callback, HttpServletResponse response){
		String str = systemService.queryTree("0");
		String json = callback + "(" + str + ")";
		super.outString(json, response);
	}
	
	

	
	
}
