package com.moda.demo.tst.dao;

import com.moda.demo.tst.entity.Area;
import com.moda.demo.tst.entity.User;
import com.moda.demo.tst.response.AreaGetSimpleResponse;
import com.moda.demo.tst.response.UserGetSimpleResponse;
import com.moda.entity.persistence.dao.BaseMyBatisDao;

/**
 * @author lyh
 * @date 2019-04-28 18:19
 **/
public interface AreaDao extends BaseMyBatisDao<Area> {
    AreaGetSimpleResponse getSimple(Integer id);
}
