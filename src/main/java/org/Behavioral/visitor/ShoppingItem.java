package org.Behavioral.visitor;

public interface ShoppingItem {

    public double accept(ShoppingCartVisitor visitor);
}
