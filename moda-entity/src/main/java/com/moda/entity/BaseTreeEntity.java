package com.moda.entity;

import java.util.List;

/**
 * 树形结构基类，需要按树形结构返回的实体应继承该类
 * 可使用方法 TreeUtils.asTree(Integer pid, List<T> lst) 进行组织为树形结构
 *
 * @author lyh
 * @create 2018-09-19 16:23
 **/
public class BaseTreeEntity<T> extends BaseEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 父级ID
     */
    private Integer pid;
    /**
     * 子节点集合
     */
    private List<T> children;

    /**
     * 根ID
     *
     * @return 0
     */
    public static Integer getRootId() {
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
