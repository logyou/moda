package com.moda.entity.rest;

/**
 * 查询
 *
 * @author lyh
 * @create 2018-09-20 13:58
 **/
public class BaseQueryPageDTO extends BaseQueryDTO {
    /**
     * 第几页
     */
    private Integer pageNo;
    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 是否是第一页
     *
     * @return boolean
     */
    public boolean isFirstPage() {
        return getPageNo().equals(1);
    }

    public Integer getPageNo() {
        return pageNo == null ? 1 : pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
