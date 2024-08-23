package com.msProject.couponService.controller;

import com.msProject.couponService.models.Coupon;
import com.msProject.couponService.service.interfaces.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private ICouponService couponService;

    @Autowired
    CouponController(ICouponService couponService){
        this.couponService = couponService;
    }

    @GetMapping("{code}")
    public ResponseEntity<Coupon> getCouponByCode(@PathVariable String code) {
        Coupon coupon = couponService.getCouponByCode(code);

        if (Objects.nonNull(coupon)) {
            return new ResponseEntity<>(coupon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon){
        boolean isCreated = couponService.saveCoupon(coupon);
        if(isCreated){
            return new ResponseEntity<>("Coupon created successfully", HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Coupon creation failed", HttpStatus.BAD_REQUEST);
        }
    }

}
