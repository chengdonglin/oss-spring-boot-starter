package com.dmai.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.dmai.oss.service.AliyunOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *    自动装配启动器类
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:21:44
 */
@Configuration
@ConditionalOnProperty(value = "dmai.oss.aliyun.enable",havingValue = "true", matchIfMissing = false)
@ConditionalOnClass(value = OSS.class)
@EnableConfigurationProperties(AliyunOssProperties.class)
public class AliyunOssAutoConfiguration {

    @Autowired
    private AliyunOssProperties ossProperties;

    @Bean
    public OSS client() {
        return new OSSClientBuilder().build(ossProperties.getEndpoint(),
                ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret());
    }


    @Bean
    public AliyunOssService aliyunOssService() {
        return new AliyunOssService();
    }
}
