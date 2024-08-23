package com.msProject.couponService.service.interfaces;

import com.msProject.couponService.models.Coupon;

public interface ICouponService {

    Coupon getCouponByCode(String code);

    boolean saveCoupon(Coupon coupon);
}
