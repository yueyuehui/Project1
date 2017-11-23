package com.jk.dao;

import com.jk.model.Purchase;
import com.jk.model.UserDTO;
import com.jk.util.OrderProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Dell 7560-1645 on 2017/11/15.
 */
@Mapper
public interface PurchaseMapper {


    @Results({
            @Result(property = "status",column = "status"),
            @Result(property = "id",column = "id"),
            @Result(property = "purchasedate",column = "purchasedate"),
            @Result(property = "remarks",column = "remarks"),
            @Result(property = "salesmae",column = "salesmae"),
            @Result(property = "arrivaldate",column = "arrivaldate"),
            @Result(property = "paydate",column = "paydate"),
            @Result(property = "payamount",column = "payamount"),
            @Result(property = "registstatus",column = "registstatus"),
            @Result(property = "purchasemoney",column = "purchasemoney")



    })

    @SelectProvider(type = OrderProvider.class, method = "queryOrderByParam")
    List<Purchase> purchaseQuery(Purchase purchase);

    @Insert ("insert into T_PURCHASE ( supplier, remarks," +
            "salesmae,payamount,status,registstatus,purchasemoney,addsalesDate,addreceiveDate,adddeliveryDate)" +
            "values ( #{supplier,jdbcType=VARCHAR},#{remarks,jdbcType=VARCHAR}," +
            "#{salesmae,jdbcType=VARCHAR},#{payamount,jdbcType=DOUBLE},#{status,jdbcType=INTEGER},#{registstatus,jdbcType=INTEGER},#{purchasemoney,jdbcType=DOUBLE},#{addsalesDate,jdbcType=DATE},#{addreceiveDate,jdbcType=DATE},#{adddeliveryDate,jdbcType=DATE})"
    )
    void addGoods(Purchase put);

    @Select("select * from P_USER")
    List<UserDTO> selectUser();
}
