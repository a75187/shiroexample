package com.security.shiro.shiroexample.mybatis.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 15:04
 * @Version: 1.0
 */

public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = -2526095345442029659L;
    protected static final int DEFAULT_PAGE = 1;
    public static int DEFAULT_PAGE_SIZE = 20;
    protected List<T> items;
    protected int recordCount;
    protected int pageSize;

    protected int currentPageStartIndex;
    protected int currentPage;

    protected String uri;

    private boolean queryRecordCount;

    public Pagination() {
        this(DEFAULT_PAGE_SIZE, 1, (String)null);
    }

    public Pagination(int pageSize, int page) {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPageStartIndex = 0;
        this.currentPage = 1;
        this.queryRecordCount = true;
        if (pageSize < 1) {
            throw new IllegalArgumentException("Count should be greater than zero!");
        } else {
            if (this.currentPage < 1) {
                boolean page1 = true;
            } else {
                this.pageSize = pageSize;
                this.currentPage = page;
            }

        }
    }

    public Pagination(int pageSize, int page, boolean queryRecordCount) {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPageStartIndex = 0;
        this.currentPage = 1;
        this.queryRecordCount = true;
        if (pageSize < 1) {
            throw new IllegalArgumentException("Count should be greater than zero!");
        } else {
            if (this.currentPage < 1) {
                boolean page1 = true;
            } else {
                this.pageSize = pageSize;
                this.currentPage = page;
            }

            this.queryRecordCount = queryRecordCount;
        }
    }

    public Pagination(int pageSize, int page, String uri) {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPageStartIndex = 0;
        this.currentPage = 1;
        this.queryRecordCount = true;
        if (pageSize < 1) {
            throw new IllegalArgumentException("Count should be greater than zero!");
        } else {
            if (this.currentPage < 1) {
                boolean page1 = true;
            } else {
                this.pageSize = pageSize;
                this.currentPage = page;
                this.uri = uri;
            }

        }
    }

    public static boolean hasResults(Pagination<?> page) {
        return null != page && null != page.getItems() && !page.getItems().isEmpty();
    }

    public void setPageSize(int countOnEachPage) {
        this.pageSize = countOnEachPage;
    }

    public List<T> getItems() {
        return this.items;
    }

    public int getRecordCount() {
        return this.recordCount;
    }

    public int getCurrentPageStartIndex() {
        this.currentPageStartIndex = (this.currentPage - 1) * this.pageSize;
        return this.currentPageStartIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setRecordCount(int totalCount) {
        this.recordCount = totalCount;
    }

    public int getPageCount() {
        return this.recordCount % this.pageSize == 0 ? this.recordCount / this.pageSize : this.recordCount / this.pageSize + 1;
    }

    public int getPreviousPage() {
        return this.currentPage > 1 ? this.currentPage - 1 : 1;
    }

    public int getNextPage() {
        return this.currentPage < this.getPageCount() ? this.currentPage + 1 : this.getPageCount();
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isQueryRecordCount() {
        return this.queryRecordCount;
    }

    public void setQueryRecordCount(boolean queryRecordCount) {
        this.queryRecordCount = queryRecordCount;
    }

    public static enum Sort {
        DESC,
        ASC;

        private Sort() {
        }
    }
}
