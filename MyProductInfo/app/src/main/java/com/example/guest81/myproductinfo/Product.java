package com.example.guest81.myproductinfo;

public class Product  {
    private long _id; //db 아이디
    private String bank; //은행명
    private String title; //상품명
    private String info; //상품소개
    private String type; //상품유형
    private String user; //대상
    private String amount; //가입금액
    private double rate; //금리
    private String term; //기간

    public Product(long _id, String bank, String title, String info, String type, String user, String amount, Double rate, String term){
        this._id = _id;
        this.bank = bank;
        this.title = title;
        this.info = info;
        this.type = type;
        this.user = user;
        this.amount = amount;
        this.rate = rate;
        this.term = term;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public long get_id() {
        return _id;
    }

    public String getBank() {
        return bank;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getAmount() {
        return amount;
    }

    public Double getRate() {
        return rate;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(_id);
        builder.append(",\t\t\t");
        builder.append(bank);
        builder.append(",\t\t\t(");
        builder.append(title);
        builder.append(",\t\t\t(");
        builder.append(info);
        builder.append(",\t\t\t(");
        builder.append(type);
        builder.append(",\t\t\t(");
        builder.append(user);
        builder.append(",\t\t\t(");
        builder.append(amount);
        builder.append(",\t\t\t(");
        builder.append(rate);
        builder.append(",\t\t\t(");
        builder.append(term);
        builder.append(",\t\t\t");

        return builder.toString();
    }
}

