package com.dmai.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:14:09
 */
@SuppressWarnings(value = "all")
@ConfigurationProperties(prefix = "dmai.oss.aliyun")
@Data
@Component
public class AliyunOssProperties {
    /**
     * 阿里云 oss 开关启动器
     */
    Boolean enable;

    /**
     * key
     */
    private String accessKeyId;

    /**
     * secret
     */
    private String accessKeySecret;

    /**
     * endpoint
     */
    private String endpoint;

    /**
     * 桶
     */
    private String bucket;

    /**
     * 请求的回调地址
     */
    private String callbackUrl;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
