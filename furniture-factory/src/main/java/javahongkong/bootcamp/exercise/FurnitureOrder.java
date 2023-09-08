package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;
import com.javahongkong.bootcamp.exercise.Furniture;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        ordersOfFurnitures = new HashMap<>();
        ordersOfFurnitures.put(Furniture.CHAIR, 0);
        ordersOfFurnitures.put(Furniture.COUCH, 0);
        ordersOfFurnitures.put(Furniture.TABLE, 0);
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        this.ordersOfFurnitures.put(type,furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalOrderCost = 0f;
        for (Map.Entry<Furniture, Integer> entry : ordersOfFurnitures.entrySet()){
            totalOrderCost += entry.getValue() * entry.getKey().cost();
        }
        return totalOrderCost;
        // return ordersOfFurnitures.get(Furniture.TABLE) * Furniture.TABLE.cost() + 
        // ordersOfFurnitures.get(Furniture.CHAIR) * Furniture.CHAIR.cost()  + 
        // ordersOfFurnitures.get(Furniture.COUCH) * Furniture.COUCH.cost() ;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return ordersOfFurnitures.get(type);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return ordersOfFurnitures.get(type) * type.cost();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        // return ordersOfFurnitures.get(Furniture.TABLE) + 
        // ordersOfFurnitures.get(Furniture.CHAIR) + 
        // ordersOfFurnitures.get(Furniture.COUCH);
        return ordersOfFurnitures.values().stream().mapToInt(Integer::intValue).sum();
    }
}