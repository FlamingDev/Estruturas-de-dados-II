/**
 * Classe que representa um produto manipulado no sistema.
 */
package entities;

public class Product{
    /**
     * nome do produto
     */
    private String name;
    /**
     * Identificador único do produto
     */
    private Integer ID;
    /**
     * Preço do produto
     */
    private Float price;

    /**
     * Construtor de um produto
     * @param name Nome do produto
     * @param ID Identificador único do produto
     * @param price Preço do produto
     */
    public Product(String name, Integer ID, Float price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    /**
     * Retorna o nome do produto
     * @return Nome do produto
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do produto
     * @param name Nome do produto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o ID do produto
     * @return ID do produto
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Define o ID do produto
     * @param ID ID do produto
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Retorna o preço do produto
     * @return Preço do produto
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Define o preço do produto
     * @param price preço do produto
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Retorna uma representação em String do objeto Product
     * @return String representando um produto
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", price=" + price +
                '}';
    }

}
