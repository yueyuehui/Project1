package com.jk.service.impl;

import java.util.List;

import com.jk.dao.SystemMapper;
import com.jk.model.Tree;
import com.jk.service.SystemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemMapper systemDao;

	@Override
	public String queryTree(String pid) {
//		调用递归
		List<Tree> trees = this.recursionTree(pid);
		return JSONArray.fromObject(trees).toString();
	}
	
	//递归：自己调用自己
		public List<Tree> recursionTree(String pid){
//			根据id查询子节点列表
			List<Tree> trees = systemDao.queryTreeByPid(pid);
//			判断查询到数据，则循环操作
			if(trees != null && trees.size()>0){
				for (int i = 0; i < trees.size(); i++) {
//					根据当前节点id查询新的子集列表，
					List<Tree> trees2 = recursionTree(trees.get(i).getId());
//					将列表set到当前树节点对象中
					trees.get(i).setNodes(trees2);
				}
			}
			return trees;
		}
		

}
