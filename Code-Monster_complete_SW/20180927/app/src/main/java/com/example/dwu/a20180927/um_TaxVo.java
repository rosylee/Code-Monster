package com.example.dwu.a20180927;

/**
 * Created by testa on 2018-09-26.
 */

public class um_TaxVo {
    private Integer COL_ID;
    private String COL_NAME;
    private String COL_YEAR;
    private String COL_MONTH;
    private String COL_DAY;
    private String COL_TAX;
    private String COL_MEMO;
    private String COL_TYPE;
    private String COL_PO_ID;

    public um_TaxVo() {

    }

    public um_TaxVo(Integer COL_ID, String COL_NAME, String COL_YEAR, String COL_MONTH, String COL_DAY, String COL_TAX, String COL_MEMO, String COL_TYPE, String COL_PO_ID) {
        this.COL_ID = COL_ID;
        this.COL_NAME = COL_NAME;
        this.COL_YEAR = COL_YEAR;
        this.COL_MONTH = COL_MONTH;
        this.COL_DAY = COL_DAY;
        this.COL_TAX = COL_TAX;
        this.COL_MEMO = COL_MEMO;
        this.COL_TYPE = COL_TYPE;
        this.COL_PO_ID = COL_PO_ID;
    }

    public Integer getCOL_ID() {
        return COL_ID;
    }

    public void setCOL_ID(Integer COL_ID) {
        this.COL_ID = COL_ID;
    }

    public String getCOL_NAME() {
        return COL_NAME;
    }

    public void setCOL_NAME(String COL_NAME) {
        this.COL_NAME = COL_NAME;
    }

    public String getCOL_YEAR() {
        return COL_YEAR;
    }

    public void setCOL_YEAR(String COL_YEAR) {
        this.COL_YEAR = COL_YEAR;
    }

    public String getCOL_MONTH() {
        return COL_MONTH;
    }

    public void setCOL_MONTH(String COL_MONTH) {
        this.COL_MONTH = COL_MONTH;
    }

    public String getCOL_DAY() {
        return COL_DAY;
    }

    public void setCOL_DAY(String COL_DAY) {
        this.COL_DAY = COL_DAY;
    }

    public String getCOL_TAX() {
        return COL_TAX;
    }

    public void setCOL_TAX(String COL_TAX) {
        this.COL_TAX = COL_TAX;
    }

    public String getCOL_MEMO() {
        return COL_MEMO;
    }

    public void setCOL_MEMO(String COL_MEMO) {
        this.COL_MEMO = COL_MEMO;
    }

    public String getCOL_TYPE() {
        return COL_TYPE;
    }

    public void setCOL_TYPE(String COL_TYPE) {
        this.COL_TYPE = COL_TYPE;
    }

    public String getCOL_PO_ID() {
        return COL_PO_ID;
    }

    public void setCOL_PO_ID(String COL_PO_ID) {
        this.COL_PO_ID = COL_PO_ID;
    }
}