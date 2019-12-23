package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * 订单
 */
public interface OrderService {

    //使用前段url上传过来的秒杀活动id，然后下单借口内校验对应id是否属于对应商品且活动已开始
    OrderModel createOrder(Integer userId,Integer itemId,Integer amount,Integer promoId) throws BusinessException;

}
