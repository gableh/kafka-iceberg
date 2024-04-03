package org.apache.flink.playground.datagen.model;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/** A supplier that generates an arbitrary transaction. */
public class TransactionSupplier implements Supplier<Transaction> {

    private final Random generator = new Random();

    private final Iterator<Long> accounts =
            Stream.generate(() -> Stream.of(1L, 2L, 3L, 4L, 5L))
          .flatMap(UnaryOperator.identity())
          .iterator();

    @Override
    public Transaction get() {
        Transaction transaction = new Transaction();
        transaction.setAccountId(accounts.next());
        transaction.setAmount(generator.nextInt(1000));
        transaction.setTimestamp(LocalDateTime.now());

        return transaction;
    }
}
