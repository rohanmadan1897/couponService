package com.msProject.couponService.controller.mappers;

import com.msProject.couponService.models.Coupon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationPackage = "com.msProject.couponService.controller.mappers.impl", implementationName = "MapCoupon")
public interface IMapCoupon {

    Coupon mapCouponToCouponDTO(Coupon coupon);
}
