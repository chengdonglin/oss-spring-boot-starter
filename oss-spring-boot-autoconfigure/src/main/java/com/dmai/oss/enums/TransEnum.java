package com.dmai.oss.enums;

/**
 * <p>
 *  是否根据视频信息自动旋转图片
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:48:06
 */
public enum TransEnum {
    /**
     * auto：指定在截图生成之后根据视频信息进行自动旋转。
     */
    AUTO("auto"),
    /**
     * 指定在截图生成之后根据视频信息强制按高大于宽的模式旋转。
     */
    H("h"),
    /**
     * 指定在截图生成之后根据视频信息强制按宽大于高的模式旋转
     */
    W("w");

    private String ar;

    TransEnum(String ar) {
        this.ar = ar;
    }

    public String getAr() {
        return ar;
    }
}
