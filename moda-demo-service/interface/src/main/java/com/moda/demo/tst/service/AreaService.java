package com.moda.demo.tst.service;

import com.moda.demo.tst.request.AreaGetSimpleRequest;
import com.moda.demo.tst.response.AreaGetSimpleResponse;
import com.moda.entity.persistence.service.BaseMyBatisService;

/**
 * @author lyh
 * @date 2019-04-28 18:05
 **/
public interface AreaService<E> extends BaseMyBatisService<E> {
    AreaGetSimpleResponse getSimple(AreaGetSimpleRequest param);
}
