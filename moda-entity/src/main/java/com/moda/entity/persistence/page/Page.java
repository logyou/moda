package com.moda.entity.persistence.page;

import com.moda.entity.BaseEntity;

import java.util.List;

/**
 * 分页数据
 *
 * @author lyh
 * @create 2018/08/27 00:16
 **/
public class Page<T> extends BaseEntity {
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 总记录数
     */
    private Long count;
    /**
     * 当前页数据
     */
    private List<T> list;

    public Page() {
    }

    /**
     * 格式化分页数据
     *
     * @param list 当前页数据
     */
    public Page(List<T> list) {
        this.list = list;
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page data = (com.github.pagehelper.Page) list;
            this.pageNo = data.getPageNum();
            this.pageSize = data.getPageSize();
            this.pageCount = data.getPages();
            this.count = data.getTotal();
        } else {
            this.count = (long) list.size();
        }
    }

    /**
     * 格式化分页数据
     *
     * @param list 当前页数据
     * @param <T>  实体
     * @return 分页数据
     */
    public static <T> Page<T> of(List<T> list) {
        return new Page<>(list);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
