package Model;

public class Medicine {
	private int id;
    private String name;
    private String category;
    private int quantity;
    private java.sql.Date expiryDate;
    private String supplier;
    private java.sql.Date soldDate;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public java.sql.Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(java.sql.Date expiryDate) { this.expiryDate = expiryDate; }
    
    public java.sql.Date getSoldDate() { return soldDate; }
    public void setSoldDate(java.sql.Date soldDate) { this.soldDate = soldDate; }
    
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier;}
	
	
}
