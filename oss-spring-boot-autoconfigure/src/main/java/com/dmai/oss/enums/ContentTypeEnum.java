package com.dmai.oss.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 16:29:05
 */
public enum ContentTypeEnum {

    BMP(".bmp","image/bmp"),
    GIF(".gif","image/gif"),
    JPEG(".jpeg","image/jpeg"),
    JPG(".jpeg","image/jpeg"),
    PNG(".png","image/jpeg"),
    HTML(".html","text/html"),
    TEXT(".txt","text/plain"),
    VSD(".vsd","application/vnd.visio"),
    PPTX(".pptx","application/vnd.ms-powerpoint"),
    PPT(".ppt","application/vnd.ms-powerpoint"),
    DOCX(".docx","application/msword"),
    DOC(".doc","application/msword"),
    XML(".xml","text/xml"),
    MP4(".mp4","video/x-mpg")
    ;

    private String key;
    private String value;

    private ContentTypeEnum(String key,String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}