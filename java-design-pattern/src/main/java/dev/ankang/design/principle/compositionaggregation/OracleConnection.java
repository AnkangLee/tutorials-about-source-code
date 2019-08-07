package dev.ankang.design.principle.compositionaggregation;

public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Oracle数据库连接";
    }
}
