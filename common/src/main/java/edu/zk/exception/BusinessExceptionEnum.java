package edu.zk.exception;

public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号已注册"),
    MEMBER_MOBILE_CODE_ERROR("验证码错误"),
    MEMBER_MOBILE_NOT_EXIST("手机号不存在"),
    BUSINESS_TRAIN_CARRIAGE_INDEX_UNIQUE_ERROR("唯一键值对已存在");
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
