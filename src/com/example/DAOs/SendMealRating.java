package com.example.DAOs;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 07.11.12
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
public class SendMealRating {
    private String userId;
    private Integer costPerformance;
    private Integer quantity;
    private Integer taste;

    public SendMealRating(String userId, Integer costPerformance, Integer quantity, Integer taste) {
        this.userId = userId;
        this.costPerformance = costPerformance;
        this.quantity = quantity;
        this.taste = taste;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCostPerformance() {
        return costPerformance;
    }

    public void setCostPerformance(Integer costPerformance) {
        this.costPerformance = costPerformance;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTaste() {
        return taste;
    }

    public void setTaste(Integer taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "SendMealRating{" +
                "userId='" + userId + '\'' +
                ", costPerformance=" + costPerformance +
                ", quantity=" + quantity +
                ", taste=" + taste +
                '}';
    }
}
