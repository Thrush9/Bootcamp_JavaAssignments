package com.stackroute.collections;

import java.util.*;

public class ProductSetService {

    private Set<Product> productSet;

    public Set<Product> getProductSet() {
        return productSet;
    }

    /*
    Constructor to initialize productSet property as empty HashSet
     */
    public ProductSetService() {
        this.productSet = new HashSet<>();
    }

    /*
    Add a new product to the product set given the product details
     */
    public boolean addProductToSet(int productId, String productName, double price) throws InvalidPriceException {
        return productSet.add(new Product(productId, productName, price));
    }

    /*
     check for a product with name eg .'Mixer' is available in the ProductSet
     If available change the product name to eg.'Mixer Grinder' and returns the new product otherwise the same product
     */
    public Product replaceProductName(String oldProductName, String newProductName) {
        Product replacedProduct = null;
        if (!productSet.isEmpty()) {
            for (Iterator<Product> iterator = productSet.iterator(); iterator.hasNext(); ) {
                Product product = iterator.next();
                if (product.getProductName().equalsIgnoreCase(oldProductName)) {
                    replacedProduct = product;
                    break;
                }
            }
        }
        if (null != replacedProduct) {
            replacedProduct.setProductName(newProductName);
        }
        return replacedProduct;
    }

    /*
    Returns the product with highest price.Hint:Product is of Comparable type comparing against price
    */
    public Product getProductWithHighestPrice() {
        if (!productSet.isEmpty()) {
            return Collections.max(productSet);
        }
        return null;
    }

    /*
    Returns set of products after removing the products whose price is greater than 5000
     */
    public Set<Product> removeProductWithPriceHigherThanFiveThousand() {
        if (!productSet.isEmpty()) {
            Set<Product> tempProductSet = new HashSet<>(productSet);
            for (Product product : tempProductSet) {
                if (product.getPrice() > 5000) {
                    productSet.remove(product);
                }
            }
        }
        return productSet;
    }

    /*
    Returns product Id list in descending order
     */
    public List<Integer> getProductIdList() {
        List<Integer> productIdList = new ArrayList<>();
        for (Product product : productSet) {
            productIdList.add(product.getProductId());
        }
        Comparator<Integer> idComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer firstId, Integer secondId) {
                return secondId - firstId;
            }
        };
        Collections.sort(productIdList, idComparator);
        return productIdList;
    }
}
