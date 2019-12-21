package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * @author Lion
 * @version 1.0
 * @date 2019/12/20 4:44 下午
 */
public interface PromoService {

    //根据itemID获取对应的秒杀活动
    PromoModel getPromoByItemId(Integer itemId);

}
