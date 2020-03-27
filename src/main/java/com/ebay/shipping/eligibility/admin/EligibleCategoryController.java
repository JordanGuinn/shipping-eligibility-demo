package com.ebay.shipping.eligibility.admin;

import com.ebay.account.Seller;
import com.ebay.account.SellerService;
import com.ebay.listing.category.Category;
import com.ebay.listing.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EligibleCategoryController {
    private static CategoryService categoryService = new CategoryService();
    private static SellerService sellerService = new SellerService();

    @RequestMapping(value = "/admin/categoryApproval", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void addCategoryToApprovalList(@RequestParam("category") Integer categoryId) {
        Category matchingCategory = categoryService.getByDisplayId(categoryId);

        //  Create one if it doesn't exist!
        if(matchingCategory == null) {
            matchingCategory = new Category();
            matchingCategory.setDisplayId(categoryId);
        }

        matchingCategory.setPreApproval(true);
        categoryService.update(matchingCategory);
    }

    @RequestMapping(value = "/admin/categoryApproval", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void removeCategoryFromApprovalList(@RequestParam("category") Integer categoryId) {
        Category matchingCategory = categoryService.getByDisplayId(categoryId);

        //  Create one if it doesn't exist!
        if(matchingCategory == null) {
            matchingCategory = new Category();
            matchingCategory.setDisplayId(categoryId);
        }

        matchingCategory.setPreApproval(false);
        categoryService.update(matchingCategory);
    }

    @RequestMapping(value = "/admin/userEnrollment", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void addUserToProgramEnrollment(@RequestParam(name = "name") String userName) {
        Seller matchingSeller = sellerService.getByUserName(userName);

        //  Create one if it doesn't exist!
        if(matchingSeller == null) {
            matchingSeller = new Seller();
            matchingSeller.setUserName(userName);
        }

        matchingSeller.setShippingEnrollment(true);
        sellerService.update(matchingSeller);
    }

    @RequestMapping(value = "/admin/userEnrollment", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void removeUserFromProgramEnrollment(@RequestParam(name = "name") String userName) {
        Seller matchingSeller = sellerService.getByUserName(userName);

        if(matchingSeller == null) {
            matchingSeller = new Seller();
            matchingSeller.setUserName(userName);
        }

        matchingSeller.setShippingEnrollment(false);
        sellerService.update(matchingSeller);
    }
}
