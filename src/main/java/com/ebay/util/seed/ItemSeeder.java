package com.ebay.util.seed;

import com.ebay.account.Seller;
import com.ebay.account.SellerService;
import com.ebay.listing.item.Item;
import com.ebay.listing.item.ItemService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

public class ItemSeeder {
    private static ItemService itemService = new ItemService();
    private static SellerService sellerService = new SellerService();

    public void seedItemTable() {
        if(itemService.list().isEmpty()) {
            List<Seller> seededSellers = sellerService.list();

            Item item1 = new Item("Television", CategorySeeder.seedCategoryDisplayIds.get(0), 395.00, seededSellers.get(0));
            Item item2 = new Item("Blender", CategorySeeder.seedCategoryDisplayIds.get(1), 85.59, seededSellers.get(1));
            Item item3 = new Item("Couch", CategorySeeder.seedCategoryDisplayIds.get(2), 595.43, seededSellers.get(2));
            Item item4 = new Item("Harry Potter and the Prisoner of Azkaban", CategorySeeder.seedCategoryDisplayIds.get(3), 11.46, seededSellers.get(3));

            itemService.create(item1);
            itemService.create(item2);
            itemService.create(item3);
            itemService.create(item4);
        }
    }
}
