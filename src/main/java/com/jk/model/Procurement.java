package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Microsoft on 2017/11/15.
 */
public class Procurement implements Serializable {

    private static final long serialVersionUID = 4934388790830980928L;

    private Integer id;//单号
    private Date cdate;//时间
    private String gys;//供应商
    private Double cg;//采购
    private Integer dj;//登记情况  1审核中(未登记) 2 审核成功(已登记)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getGys() {
        return gys;
    }

    public void setGys(String gys) {
        this.gys = gys;
    }

    public Double getCg() {
        return cg;
    }

    public void setCg(Double cg) {
        this.cg = cg;
    }

    public Integer getDj() {
        return dj;
    }

    public void setDj(Integer dj) {
        this.dj = dj;
    }

    @Override
    public String toString() {
        return "Procurement{" +
                "id=" + id +
                ", cdate=" + cdate +
                ", gys='" + gys + '\'' +
                ", cg=" + cg +
                ", dj=" + dj +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Procurement that = (Procurement) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
