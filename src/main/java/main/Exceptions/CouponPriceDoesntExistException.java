package main.Exceptions;

public class CouponPriceDoesntExistException extends Exception {
    public CouponPriceDoesntExistException(){
        super("Coupon Price Doesnt Exist");
    }
}
