package com.moda.demo.tst.service.impl;

import com.moda.demo.tst.dao.AreaDao;
import com.moda.demo.tst.entity.Area;
import com.moda.demo.tst.request.AreaGetSimpleRequest;
import com.moda.demo.tst.response.AreaGetSimpleResponse;
import com.moda.demo.tst.service.AreaService;
import com.moda.entity.persistence.service.impl.BaseMyBatisServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lyh
 * @date 2019-04-28 18:18
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AreaServiceImpl extends BaseMyBatisServiceImpl<AreaDao, Area> implements AreaService<Area> {

    @Override
    public AreaGetSimpleResponse getSimple(AreaGetSimpleRequest param) {
        return dao.getSimple(param.getId());
    }
}
