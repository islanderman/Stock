package us.chenyang.personal.stock.m1.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.chenyang.personal.stock.m1.model.Stock;
import us.chenyang.personal.stock.m1.model.enums.Category;
import us.chenyang.personal.stock.m1.model.enums.Filter;
import us.chenyang.personal.stock.m1.model.enums.SortBy;

public final class DataRetrieval {

    private DataRetrieval() {
    }

    private static final List<String> HIERARCHY = Arrays.asList("data", "node", "rootPortfolioSlice", "investments",
            "_allocatedPositions1Lvfod", "edges");

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static List<Stock> readFromJson(File file) throws IOException {
        JsonNode data = MAPPER.readTree(file);

        for (String step : HIERARCHY) {
            data = data.get(step);
        }

        Stock[] stocks = MAPPER.convertValue(data, Stock[].class);

        return Arrays.asList(stocks);
    }

    public static List<Stock> sortBy(List<Stock> stocks, SortBy sort) {
        return stocks.parallelStream().sorted(sort.getComparator()).collect(Collectors.toList());
    }

    public static List<Stock> filterBy(List<Stock> stocks, Filter filter) {
        return stocks.parallelStream().filter(filter.getPredicate()).collect(Collectors.toList());
    }

    public static Map<Category, List<Stock>> groupBy(List<Stock> stocks) {
        return stocks.parallelStream().sorted(SortBy.COST.getComparator())
                .collect(Collectors.groupingBy(FunctionUtils.CATEGORY_GROUPING, Collectors.toList()));
    }
}
