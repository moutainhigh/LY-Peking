package com.zscat.mallplus.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zscat.mallplus.oms.vo.CartMarkingVo;
import com.zscat.mallplus.sms.entity.SmsBasicMarking;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zscat
 * @since 2019-07-07
 */
public interface ISmsBasicMarkingService extends IService<SmsBasicMarking> {

    int updateStatus(Long id, Integer status, Integer bigType);

    /**
     * 满足所有符合商品的优惠
     * @param id
     * @return
     */
    List<SmsBasicMarking> matchGoodsBasicMarking(Long id);

    /**
     * 满足订单商品的满减和折扣 取优惠最大的那个
     * @param vo
     * @return
     */
    SmsBasicMarking matchOrderBasicMarking(CartMarkingVo vo);
}
