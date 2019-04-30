package com.moda.entity.persistence.service.impl;

import com.moda.entity.persistence.service.BaseMyBatisService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base MyBatis Service 实现抽象类
 *
 * @author lyh
 * @date 2019-04-29 00:17:23
 **/
@Transactional(readOnly = true, rollbackFor = Exception.class)
public abstract class BaseMyBatisServiceImpl implements BaseMyBatisService {
}
