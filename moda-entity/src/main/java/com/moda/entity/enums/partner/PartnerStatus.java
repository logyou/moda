/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.enums.partner;

import com.moda.entity.enums.BaseEnum;
import com.moda.entity.enums.EnumConverter;

/**
 *                       
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年5月11日</li>
 *
 */

/**
 * 合伙人状态
 */
public enum PartnerStatus implements BaseEnum {
                                               NEW(10, "新建"), //
                                               WAITING_COMMIT(12, "新建未提交"), //
                                               SIGN_INFO_WAITING_AUDIT(3, "签约信息待审核"), //
                                               SING_INFO_AUDIT_FAIL(11, "签约信息审核不通过"), //
                                               WAITING_PAY_FIRST_AMOUNT(2, "待付首笔货款"), //
                                               FAILED(4, "已失效"), //
                                               TO_BE_TRAINED(7, "待培训"), //
                                               TRAINING_APPLICATION(8, "培训申请中"), //
                                               TRAINING(9, "培训中"), //
                                               NORMAL(1, "正常使用"), //
                                               DISQUALIFICATION(5, "已失去资格"), //
                                               DISABLE(6, "禁用");

    private Integer value;
    private String  text;

    PartnerStatus(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public String text() {
        return text;
    }

    public static PartnerStatus valueOf(Integer value) {
        return EnumConverter.valueOf(PartnerStatus.class, value);
    }
}
