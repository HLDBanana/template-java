package com.hanergy.out.vo;

/**
 * @author DURONGHONG
 * @version 1.0
 * @className SearchVo
 * @description TODO
 * @date 2019-4-29 10:37
 **/
public class SearchVo {

    private String userKey;

    private String userValue;

    private String eqOrLike;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserValue() {
        return userValue;
    }

    public void setUserValue(String userValue) {
        this.userValue = userValue;
    }

    public String getEqOrLike() {
        return eqOrLike;
    }

    public void setEqOrLike(String eqOrLike) {
        this.eqOrLike = eqOrLike;
    }
}
