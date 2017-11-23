package com.jk.service.impl;

import com.jk.dao.ProcurementMapper;
import com.jk.model.Procurement;
import com.jk.service.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Microsoft on 2017/11/15.
 */
@Service
public class ProcurementServiceImpl implements ProcurementService {
    @Autowired
    private ProcurementMapper procurementMapper;
    @Override
    public HashMap<String, Object> selectInvest(Map<String, Object> map) {
        List list = null;
        HashMap<String, Object> m = new HashMap<>();
        list = procurementMapper.selAllOrg(map);
        Long count = procurementMapper.queryCount(map);
        m.put("total", count);
        m.put("rows", list);
        return m;
    }

    @Override
    public List<Procurement> procurementList() {

        return procurementMapper.procurementList();
    }

    @Override
    public List<Procurement> purchaseQuery(Map<String, String> map) {
        StringBuffer  sb=new StringBuffer("where  1=1 ");
        if(map!=null){
            String dj = map.get("dj");
            String datebegin = map.get("datebegin");
            String dateend = map.get("dateend");
            String gys = map.get("gys");

            if(dj!=null&&!"".equals(dj)){
                sb.append("and dj="+dj);
            }
            if(datebegin!=null&&!"".equals(datebegin)){
                sb.append("and cdate>="+datebegin);
            }
            if(dateend!=null&&!"".equals(dateend)){
                sb.append("and cdate<="+dateend);
            }
            if(gys!=null&&!"".equals(gys)){
                sb.append("and gys="+gys);
            }
        }
        List<Procurement> list=procurementMapper.purchaseQuery(sb.toString());
        return null;
    }


}
