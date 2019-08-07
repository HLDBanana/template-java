package com.hanergy.out.vo;

/**
 * @author DURONGHONG
 * @version 1.0
 * @className EsourcingQueryVo
 * @description TODO
 * @date 2019-4-29 10:35
 **/
public class EsourcingQueryVo {

//    private Map<String,Object> searchParams;

    private SearchVo searchParams;


    private Integer pageNo;

    private Integer pageSize;

//    private Boolean encrypt= true;
//
//    public Boolean getEncrypt() {
//        return encrypt;
//    }
//
//    public void setEncrypt(Boolean encrypt) {
//        this.encrypt = encrypt;
//    }

    public SearchVo getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(SearchVo searchParams) {
        this.searchParams = searchParams;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
