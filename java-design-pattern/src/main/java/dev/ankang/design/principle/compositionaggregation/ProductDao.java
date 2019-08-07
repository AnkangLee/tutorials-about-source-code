package dev.ankang.design.principle.compositionaggregation;

/**
 * 使用对象组合或者聚合而不是继承来实现软件复用的目的。
 */
public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct() {
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }
}
