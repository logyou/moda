package com.moda.util.tree;

import com.moda.entity.BaseTreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构处理
 *
 * @author lyh
 * @create 2018-09-19 16:30
 **/
public class TreeUtils {
    /**
     * 创建树形结构
     *
     * @param pid 父级ID
     * @param lst 列表
     * @return
     */
    public static <T extends BaseTreeEntity> List<T> asTree(Integer pid, List<T> lst) {
        List<T> tree = new ArrayList<>();
        for (T m : lst) {
            if (m.getPid().equals(pid)) {
                m.setChildren(asTree(m.getId(), lst));
                tree.add(m);
            }
        }
        return tree;
    }
}
