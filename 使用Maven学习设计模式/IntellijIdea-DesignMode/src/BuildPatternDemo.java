import com.BuilderPattern.Builder.Meal;
import com.BuilderPattern.Builder.MealBulder;

public class BuildPatternDemo {

    public static void main(String[] args) {
        MealBulder mealBulder = new MealBulder();
        //来一份 鸡堡套餐（包含鸡腿堡和百事可乐）
        Meal chickenMeal= mealBulder.prepareChickenMeal();
        chickenMeal.ShowAllItems();
        //来一份 素套餐（包含素堡和可口可乐）
        Meal vegMeal = mealBulder.prepareVegMeal();
        vegMeal.ShowAllItems();
        vegMeal.getAllCodts();
    }
}
