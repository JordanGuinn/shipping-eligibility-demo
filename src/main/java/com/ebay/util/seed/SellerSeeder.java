package com.ebay.util.seed;

import com.ebay.account.Seller;
import com.ebay.account.SellerService;

public class SellerSeeder {
    private static SellerService sellerService = new SellerService();

    public void seedSellersTable() {
        if(sellerService.list().isEmpty()) {
            Seller seller1 = new Seller("david", false);
            Seller seller2 = new Seller("emily", false);
            Seller seller3 = new Seller("michael", true);
            Seller seller4 = new Seller("dianne", false);

            sellerService.create(seller1);
            sellerService.create(seller2);
            sellerService.create(seller3);
            sellerService.create(seller4);
        }
    }
}
