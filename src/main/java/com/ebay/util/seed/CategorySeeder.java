package com.ebay.util.seed;

import com.ebay.listing.category.Category;
import com.ebay.listing.category.CategoryService;
import com.ebay.listing.item.Item;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.List;

public class CategorySeeder {
    public static final List<Integer> seedCategoryDisplayIds = Arrays.asList(1, 2, 3, 4);

    private static CategoryService categoryService = new CategoryService();

    public void seedCategoryTable() {
        if(categoryService.list().isEmpty()) {
            Category category1 = new Category(seedCategoryDisplayIds.get(0), "Electronics", true);
            Category category2 = new Category(seedCategoryDisplayIds.get(1), "Household Items", false);
            Category category3 = new Category(seedCategoryDisplayIds.get(2), "Furniture", false);
            Category category4 = new Category(seedCategoryDisplayIds.get(3), "Books", true);

            categoryService.create(category1);
            categoryService.create(category2);
            categoryService.create(category3);
            categoryService.create(category4);
        }
    }
}
