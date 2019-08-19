package dev.ankang.design.pattern.structural.facade;

import org.junit.Test;

import static org.junit.Assert.*;

public class GiftExchangeServiceTest {

    @Test
    public void giftExchange() {
        PointsGift pointsGift = new PointsGift("T恤");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
}