package com.ebay.shipping.eligibility;

import com.ebay.account.Seller;
import com.ebay.account.SellerService;
import com.ebay.listing.category.Category;
import com.ebay.listing.category.CategoryService;
import com.ebay.listing.item.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShippingEligibilityController {
    private static SellerService sellerService = new SellerService();
    private static CategoryService categoryService = new CategoryService();
    private static ItemService itemService = new ItemService();

    private static final Double minimumPrice = 9.99;

    public static Double getMinimumPrice() {
        return minimumPrice;
    }

    @RequestMapping(value = "/item/isValid", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Boolean getItemValidity(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "seller") String userName,
            @RequestParam(name = "category") Integer categoryId,
            @RequestParam(name = "price") Double price
    ) {
        Category matchingCategory = categoryService.getByDisplayId(categoryId);
        if (matchingCategory == null) {
            System.out.println("No category found for categoryId provided");
            return false;
        }

        if (!matchingCategory.isPreApproved()) {
            System.out.println("Category has not been approved for shipping eligibility");
            return false;
        }

        Seller matchingSeller = sellerService.getByUserName(userName);
        if (matchingSeller == null) {
            System.out.println("No seller found for userName provided");
            return false;
        }

        if (!matchingSeller.isEnrolledInShippingProgram()) {
            System.out.println("Seller is not enrolled in shipping eligibility");
            return false;
        }

        if (getMinimumPrice() > price) {
            System.out.println("Price does not meet minimum price requirements");
            return false;
        }

        return true;
    }
}
