package com.jk.service;

import com.jk.model.Procurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Microsoft on 2017/11/15.
 */
public interface ProcurementService {
    /**
     * 查询 条件 分页
     * @param map
     * @return
     */
    HashMap<String,Object> selectInvest(Map<String, Object> map);

    /**
     * easy U i 查询
     * @return
     */
    List<Procurement> procurementList();

    /**
     * bootstrap  查询分页 条件查
     * @param map
     * @return
     */
    List<Procurement> purchaseQuery(Map<String, String> map);
}

