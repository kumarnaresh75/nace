package com.db.nace.util;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class StreamUtil {

    public Supplier<Stream<Row>> getRowsStreamSupplier(Iterable<Row> rows){
        return () -> getStream(rows);
    }

    public <T> Stream<T> getStream(Iterable<T> iterable){
        return StreamSupport.stream(iterable.spliterator(),false);
    }

}
