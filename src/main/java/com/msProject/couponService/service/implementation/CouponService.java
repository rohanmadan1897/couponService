package com.msProject.couponService.service.implementation;

import com.msProject.couponService.controller.mappers.IMapCoupon;
import com.msProject.couponService.models.Coupon;
import com.msProject.couponService.persistence.CouponRepository;
import com.msProject.couponService.service.interfaces.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CouponService implements ICouponService {
    private CouponRepository couponRepository;
    private IMapCoupon couponMapper;

    @Autowired
    public CouponService(CouponRepository couponRepository, IMapCoupon couponMapper) {
        this.couponRepository = couponRepository;
        this.couponMapper = couponMapper;
    }

    @Override
    public Coupon getCouponByCode(String code) {

        Coupon coupon = couponRepository.findByCode(code);
        if(Objects.nonNull(coupon)){
            return coupon;
        } else{
            return null;
        }
    }

    @Override
    public boolean saveCoupon(Coupon coupon) {
        Coupon couponModel = couponMapper.mapCouponToCouponDTO(coupon);
        if(couponModel.getCode() == null){
            return false;
        }else {
            couponRepository.save(coupon);
            return true;
        }
    }


}
