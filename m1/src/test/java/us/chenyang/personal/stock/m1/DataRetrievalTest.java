package us.chenyang.personal.stock.m1;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import us.chenyang.personal.stock.m1.model.Stock;
import us.chenyang.personal.stock.m1.model.enums.Category;
import us.chenyang.personal.stock.m1.model.enums.SortBy;
import us.chenyang.personal.stock.m1.utils.DataRetrieval;

public class DataRetrievalTest {

    @Test
    public void read() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tick.json").getFile());
        assertNotNull(file);
    }

    @Test
    public void readJson() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tick.json").getFile());

        assertNotNull(DataRetrieval.readFromJson(file));
    }

    @Test
    public void sortBy() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tick.json").getFile());
        List<Stock> stocks = DataRetrieval.sortBy(DataRetrieval.readFromJson(file), SortBy.VALUE);
        assertNotNull(stocks);

        Collections.reverse(stocks);

        System.out.println(stocks.stream().map(Stock::getTick).collect(Collectors.joining(",")));
    }

    @Test
    public void groupBy() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tick.json").getFile());
        Map<Category, List<Stock>> stocks = DataRetrieval.groupBy(DataRetrieval.readFromJson(file));
        assertNotNull(stocks);
    }
}
