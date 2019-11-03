package us.chenyang.personal.stock.m1.model.enums;

import static us.chenyang.personal.stock.m1.utils.FunctionUtils.LOSS_FILTER;
import static us.chenyang.personal.stock.m1.utils.FunctionUtils.PROFIT_FILTER;

import java.util.function.Predicate;

import us.chenyang.personal.stock.m1.model.Stock;

public enum Filter {
    PROFIT(PROFIT_FILTER), LOSS(LOSS_FILTER);

    private Predicate<Stock> predicate;

    private Filter(Predicate<Stock> predicate) {
        this.predicate = predicate;
    }

    public Predicate<Stock> getPredicate() {
        return predicate;
    }
}
