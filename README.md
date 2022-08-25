# 自定义  oss starter

## 使用步骤

```yaml
dmai:
  oss:
    aliyun:
      enable: true
      access-key-id: oss key
      access-key-secret: secret
      endpoint: endpoint
      bucket: bucket
      callback-url: callback
```

```java
      @Autowired
      private AliyunOssService aliyunOssService;
  
      @Autowired
      private AliyunOssProperties ossProperties;
      
      @Autowired
      private OSS oss;

```