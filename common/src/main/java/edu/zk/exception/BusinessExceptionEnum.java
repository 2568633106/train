package edu.zk.exception;

public enum BusinessExceptionEnum {
    MEMER_MOBILE_EXIST("手机号已注册"),
    MEMER_CODE_ERROR("手机号已注册"),
    MEMER_MOBILE_NOEXIST("手机号不存在");
    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
