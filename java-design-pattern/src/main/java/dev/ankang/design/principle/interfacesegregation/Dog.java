package dev.ankang.design.principle.interfacesegregation;

public class Dog implements IEatAnimalAction,ISwimAnimalAction {
    @Override
    public void eat() {
        System.out.println("eat gouliang ????");
    }

    @Override
    public void swim() {
        System.out.println("swim like a dog !!!");
    }
}
