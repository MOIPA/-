package com.PrototypePattern;

import com.PrototypePattern.Interface.Shape;
import com.PrototypePattern.entity.Rectangle;
import com.PrototypePattern.entity.Square;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /**
     * 查询数据库 生成对象列表存储到表中
     */
    public static void loadCache() {
        Square square = new Square();
        square.setId("1");
        shapeMap.put("1", square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put("2", rectangle);
    }
}
