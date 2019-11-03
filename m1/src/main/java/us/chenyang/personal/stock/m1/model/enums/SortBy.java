package us.chenyang.personal.stock.m1.model.enums;

import static us.chenyang.personal.stock.m1.utils.FunctionUtils.COST_COMPARATOR;
import static us.chenyang.personal.stock.m1.utils.FunctionUtils.TICK_COMPARATOR;
import static us.chenyang.personal.stock.m1.utils.FunctionUtils.VALUE_COMPARATOR;

import java.util.Comparator;

import us.chenyang.personal.stock.m1.model.Stock;

public enum SortBy {
    TICK(TICK_COMPARATOR), COST(COST_COMPARATOR), VALUE(VALUE_COMPARATOR);

    private Comparator<Stock> comparator;

    private SortBy(Comparator<Stock> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Stock> getComparator() {
        return comparator;
    }
}
