public class Product {
    private Long id;
    private String productTitle;
    private int cost;

    public Product(String productTitle){
        this.productTitle = productTitle;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = this.id;
    }
    public String getProductTitle(){
        return productTitle;
    }
    public void setProductTitle(){
        this.productTitle = productTitle;
    }
    public void setCost(){
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }

    public void put(Long id, Product products) {
    }
}
