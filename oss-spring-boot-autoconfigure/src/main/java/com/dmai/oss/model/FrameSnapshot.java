package com.dmai.oss.model;

import com.dmai.oss.enums.SnapshotEnum;
import com.dmai.oss.enums.TransEnum;

/**
 * <p>
 *  视频截帧参数
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:40:27
 */
public class FrameSnapshot {
    /**
     * 截图高度，指定为0，自动计算
     */
    private Integer height = 0;

    /**
     * 截图宽度,指定为0， 自动计算
     * 如果w和h都为0，则输出为原视频宽高。
     */
    private Integer width = 0;

    /**
     * 截图时间，单位ms
     */
    private Integer time = 0;

    /**
     * 图片格式
     */
    private SnapshotEnum format = SnapshotEnum.JPG;

    /**
     * 是否根据视频信息自动旋转图片
     */
    private TransEnum ar = TransEnum.AUTO;


    public FrameSnapshot(Integer height, Integer width, Integer time, SnapshotEnum format, TransEnum ar) {
        this.height = height;
        this.width = width;
        this.time = time;
        this.format = format;
        this.ar = ar;
    }

    public FrameSnapshot() {
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public SnapshotEnum getFormat() {
        return format;
    }

    public void setFormat(SnapshotEnum format) {
        this.format = format;
    }

    public TransEnum getAr() {
        return ar;
    }

    public void setAr(TransEnum ar) {
        this.ar = ar;
    }
}
