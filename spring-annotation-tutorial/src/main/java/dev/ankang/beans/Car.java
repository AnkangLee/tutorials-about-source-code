package dev.ankang.beans;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class Car {

    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        System.out.println(this.name + " car constructor...");
    }

    public void init() {
        System.out.println(name + " car...init...");
    }

    public void destroy() {
        System.out.println(name + " car...destroy...");
    }
}
