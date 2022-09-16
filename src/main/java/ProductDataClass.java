public final class ProductDataClass {

    private final String productName;
    private final String productDescription;

    private final String emptyProductName;
    private final String emptyProductDescription;

    private final String category;
    private final String provider;
    private final String brand;

    public ProductDataClass(String productName, String productDescription, String emptyProductName, String emptyProductDescription, String category, String provider, String brand) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.emptyProductName = emptyProductName;
        this.emptyProductDescription = emptyProductDescription;
        this.category = category;
        this.provider = provider;
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public String getProvider() {
        return provider;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductName() {
        return productName;
    }

    public String getEmptyProductName() {
        return emptyProductName;
    }

    public String getEmptyProductDescription() {
        return emptyProductDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
