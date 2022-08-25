package com.dmai.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.StringUtils;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.dmai.oss.config.AliyunOssProperties;
import com.dmai.oss.enums.ContentTypeEnum;
import com.dmai.oss.exception.AliyunOssException;
import com.dmai.oss.model.FrameSnapshot;
import com.dmai.oss.model.OssResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-25 15:30:41
 */
@SuppressWarnings(value = "all")
public class AliyunOssService {

    private static final String HTTPS = "https://";

    private static final int MAX_SIZE = 1024 * 1024 * 2;

    @Autowired
    private OSS oss;

    @Autowired
    private AliyunOssProperties ossProperties;

    /**
     * 获取 oss key  临时访问地址
     * @param key  存储的key
     * @param duration  访问有效期
     * @return URL
     */
    public String getPublicUrl(String key, Duration duration) {
        Date expiration = this.getExpireTime(duration);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(ossProperties.getBucket(), key);
        request.setExpiration(expiration);
        return oss.generatePresignedUrl(request).toString();
    }

    /**
     * 视频截帧
     * https://help.aliyun.com/document_detail/64555.html
     * @param key 存储oss key
     * @param duration  访问有效期
     * @param snapshot 截帧参数
     * @return
     */
    public String getVideoFrame(String key, Duration duration, FrameSnapshot snapshot) {
        Date expiration = this.getExpireTime(duration);
        String style = this.getStyle(snapshot);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(ossProperties.getBucket(), key);
        request.setExpiration(expiration);
        request.setProcess(style);
        return oss.generatePresignedUrl(request).toString();
    }

    /**
     * 计算过期时间
     * @param duration
     * @return
     */
    private Date getExpireTime(Duration duration) {
        return new Date(System.currentTimeMillis() + duration.toMillis());
    }

    /**
     * 截帧参数
     * @param snapshot
     * @return
     */
    private String getStyle(FrameSnapshot snapshot) {
        return String.format("video/snapshot,t_%d,f_%s,w_%d,h_%d,m_fast",snapshot.getTime(),snapshot.getFormat().getType(),snapshot.getWidth(),snapshot.getHeight());
    }

    /**
     * 上传文件
     * @param key key
     * @param inputStream  文件流
     * @param contentType 文件类型
     * @param accessControlList
     * @return
     * @throws AliyunOssException
     */
    public OssResult upload(String key, InputStream inputStream, ContentTypeEnum contentType, CannedAccessControlList accessControlList) throws AliyunOssException {
        if (StringUtils.isNullOrEmpty(key)) {
            throw new AliyunOssException("upload key can not be empty");
        }
        if (StringUtils.isNullOrEmpty(contentType.getKey())) {
            throw new AliyunOssException("upload file type can not empty");
        }
        String position = this.getKey(key, contentType);
        oss.putObject(ossProperties.getBucket(), position, inputStream);
        // 设置权限
        if (Optional.ofNullable(accessControlList).isPresent()) {
            oss.setObjectAcl(ossProperties.getBucket(),position,accessControlList);
        }
        OssResult result = new OssResult();
        result.setKey(position);
        if (accessControlList.equals(CannedAccessControlList.PublicRead) || accessControlList.equals(CannedAccessControlList.PublicReadWrite)) {
            result.setUrl(this.getPublicRead(position));
        } else {
            result.setUrl(this.getPublicUrl(position,Duration.ofHours(2)));
        }
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    private String getKey(String key,ContentTypeEnum contentType) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int monthValue = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String format = String.format("%d-%d-%d",year,monthValue,dayOfMonth);
        return String.format("%s/%s-%s%s",format,uuid,key,contentType.getKey());
    }


    private String getPublicRead(String key) {
        return HTTPS + ossProperties.getBucket() + "."  + ossProperties.getEndpoint().replaceAll(HTTPS,"") + "/" + key;
    }

}
