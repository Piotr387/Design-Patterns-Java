package org.structural.decorator;

public class Sugar extends BeverageDecorator {

    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return this.beverage.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " sugar ";
    }
}
