package com.jk.util;

import com.jk.model.Purchase;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

public class OrderProvider {
    private final String TBL_ORDER = "T_PURCHASE";

    public String queryOrderByParam(Purchase pur) {
        SQL sql = new SQL().SELECT("*").FROM(TBL_ORDER);
        if (pur.getStatus()!=null&&!"".equals(pur.getStatus())){
            sql.WHERE("status = #{status}");
        }
        if (pur.getRegiststatus() != null && !"".equals(pur.getRegiststatus())) {
            sql.WHERE("registstatus = #{registstatus}");
        }
        if (StringUtils.hasText(pur.getSupplier())){
            sql.WHERE("supplier like #{supplier}");
        }

        if (StringUtils.hasText(pur.getStartDate())){
            sql.WHERE("purchasedate >= to_date('#{startdate}','yyyy-MM-dd')");
        }
        if (StringUtils.hasText(pur.getEndDate())){
            sql.WHERE("purchasedate <= to_date('${enddate}','yyyy-MM-dd')");
        }
        return sql.toString();
    }
}
