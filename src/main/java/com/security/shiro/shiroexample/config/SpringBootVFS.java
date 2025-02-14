package com.security.shiro.shiroexample.config;

import org.apache.ibatis.io.VFS;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 15:10
 * @Version: 1.0
 */

public class SpringBootVFS  extends VFS {
    private final ResourcePatternResolver resourceResolver;

    public SpringBootVFS() {
        this.resourceResolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    protected List<String> list(URL url, String path) throws IOException {
        Resource[] resources = resourceResolver.getResources("classpath*:" + path + "/**/*.class");
        return Stream.of(resources)
                .map(resource -> preserveSubpackageName(resource, path))
                .collect(Collectors.toList());
    }

    private static String preserveSubpackageName(final Resource resource, final String rootPath) {
        try {
            final String uriStr = resource.getURI().toString();
            final int start = uriStr.lastIndexOf(rootPath);
            return uriStr.substring(start);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
