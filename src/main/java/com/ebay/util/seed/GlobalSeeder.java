package com.ebay.util.seed;

public class GlobalSeeder {

    public void seedAllTables() {
        System.out.println("Initiating table seeding...");

        new SellerSeeder().seedSellersTable();
        new CategorySeeder().seedCategoryTable();
        new ItemSeeder().seedItemTable();

        System.out.println("All table seeding complete");
    }
}
