package com.dmai.oss.model;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 16:41:06
 */
public class OssResult {

    /**
     * 文件存储key
     */
    private String key;

    /**
     * 文件存储URL， 如果不是公共读话, url有过期时间
     */
    private String url;

    public OssResult() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
