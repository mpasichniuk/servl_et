public class ProductSpring {
    private Long id;
    private String productTitle;
    private int cost;

    public ProductSpring(String productTitle, long id, int cost){
        this.productTitle = productTitle;
        this.id = id;
        this.cost = cost;

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

    public void put(Long id, ProductSpring products) {
    }
}

