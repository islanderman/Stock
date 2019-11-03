package us.chenyang.personal.stock.m1.utils;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import us.chenyang.personal.stock.m1.model.Stock;
import us.chenyang.personal.stock.m1.model.enums.Category;

public class FunctionUtils {
    public static final Comparator<Stock> VALUE_COMPARATOR = (o1, o2) -> {
        return Double.compare(o2.getNode().getPosition().getValue().getValue(), o1.getNode().getPosition().getValue().getValue());
    };

    public static final Comparator<Stock> COST_COMPARATOR = (o1, o2) -> {
        if (o2.getNode().getPosition().getCost() == null) {
            return -1;
        }

        if (o1.getNode().getPosition().getCost() == null) {
            return 1;
        }

        return Double.compare(o2.getNode().getPosition().getCost().getCost(), o1.getNode().getPosition().getCost().getCost());
    };

    public static final Comparator<Stock> TICK_COMPARATOR = (o1, o2) -> {
        return StringUtils.compare(o2.getNode().getPosition().getSecurity().getSymbol(),
                o1.getNode().getPosition().getSecurity().getSymbol());
    };

    public static final Function<Stock, Category> CATEGORY_GROUPING = (stock) -> {
        if (stock.getNode().getPosition().getUnrealizedGain() == null) {
            return Category.UNDETERMINED;
        }

        return stock.getNode().getPosition().getUnrealizedGain().getGain() >= 0 ? Category.PROFIT : Category.LOSS;
    };

    public static Predicate<Stock> PROFIT_FILTER = (stock) -> CATEGORY_GROUPING.apply(stock) == Category.PROFIT;

    public static Predicate<Stock> LOSS_FILTER = (stock) -> CATEGORY_GROUPING.apply(stock) == Category.LOSS;
}
