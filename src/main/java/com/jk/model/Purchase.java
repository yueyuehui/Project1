package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dell 7560-1645 on 2017/11/15.
 */
public class Purchase implements Serializable {

    private Integer id;
    private String supplier;
    private Date purchasedate;
    private String remarks;
    private String salesmae;
    private Date arrivaldate;
    private Date paydate;
    private  Integer payamount;
    private Integer  status;
    private Integer registstatus;
    private Integer purchasemoney;

    private String startDate;
    private String endDate;
    private String addsalesDate;
    private String addreceiveDate;
    private String adddeliveryDate;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSalesmae() {
        return salesmae;
    }

    public void setSalesmae(String salesmae) {
        this.salesmae = salesmae;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRegiststatus() {
        return registstatus;
    }

    public void setRegiststatus(Integer registstatus) {
        this.registstatus = registstatus;
    }

    public Integer getPurchasemoney() {
        return purchasemoney;
    }

    public void setPurchasemoney(Integer purchasemoney) {
        this.purchasemoney = purchasemoney;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPayamount() {
        return payamount;
    }

    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    public String getAddsalesDate() {
        return addsalesDate;
    }

    public void setAddsalesDate(String addsalesDate) {
        this.addsalesDate = addsalesDate;
    }

    public String getAdddeliveryDate() {
        return adddeliveryDate;
    }

    public void setAdddeliveryDate(String adddeliveryDate) {
        this.adddeliveryDate = adddeliveryDate;
    }

    public String getAddreceiveDate() {
        return addreceiveDate;
    }

    public void setAddreceiveDate(String addreceiveDate) {
        this.addreceiveDate = addreceiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        return id.equals(purchase.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", supplier='" + supplier + '\'' +
                ", purchasedate=" + purchasedate +
                ", remarks='" + remarks + '\'' +
                ", salesmae='" + salesmae + '\'' +
                ", arrivaldate=" + arrivaldate +
                ", paydate=" + paydate +
                ", payamount=" + payamount +
                ", status=" + status +
                ", registstatus=" + registstatus +
                ", purchasemoney=" + purchasemoney +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", addsalesDate='" + addsalesDate + '\'' +
                ", addreceiveDate='" + addreceiveDate + '\'' +
                ", adddeliveryDate='" + adddeliveryDate + '\'' +
                '}';
    }
}
