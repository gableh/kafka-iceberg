package org.apache.flink.playground.datagen.model;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.flink.api.common.serialization.SerializationSchema;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TransactionSerializer implements SerializationSchema<Transaction> {

    @Override
    public byte[] serialize(Transaction transaction) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
            DatumWriter<Transaction> writer = new SpecificDatumWriter<>(Transaction.class);
            writer.write(transaction, encoder);
            encoder.flush();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            // Handle serialization exception
            e.printStackTrace();
            return null;
        }
    }
}
