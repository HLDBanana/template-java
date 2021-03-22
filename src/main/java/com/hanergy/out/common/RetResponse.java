package com.hanergy.out.common;


public final class RetResponse {
    private RetResponse() {
    }

    public static <T> RetResult<T> makeOKRsp() {
        return new RetResult(DmStatus.OK, new String[]{DmStatus.OK.getFormattedErrorMessage(new String[0])});
    }

    public static <T> RetResult<T> makeOKRsp(T data) {
        RetResult<T> retResult = new RetResult(DmStatus.OK, new String[]{DmStatus.OK.getFormattedErrorMessage(new String[0])});
        retResult.setData(data);
        return retResult;
    }

    public static <T> RetResult<T> makeRsp(DmStatus commonEnum) {
        return new RetResult(commonEnum, new String[]{commonEnum.getErrorMessage()});
    }

    public static <T> RetResult<T> makeErrRsp(String message) {
        return new RetResult(DmStatus.BAD_REQUEST, new String[]{message});
    }

    public static <T> RetResult<T> makeErrRsp(DmStatus dmStatus, String message) {
        return new RetResult(DmStatus.BAD_REQUEST, new String[]{message});
    }
}
