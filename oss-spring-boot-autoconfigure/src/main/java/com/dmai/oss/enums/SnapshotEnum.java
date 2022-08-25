package com.dmai.oss.enums;

/**
 * <p>
 *  输出图片的格式枚举
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:44:50
 */
public enum SnapshotEnum {
    /**
     * jpg
     */
    JPG("jpg"),
    /**
     * png
     */
    PNG("png");
    /**
     * 图片格式
     */
    private String type;

    SnapshotEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
