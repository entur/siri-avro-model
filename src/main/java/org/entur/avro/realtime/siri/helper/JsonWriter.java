package org.entur.avro.realtime.siri.helper;

import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.entur.avro.realtime.siri.model.EstimatedVehicleJourneyRecord;
import org.entur.avro.realtime.siri.model.PtSituationElementRecord;
import org.entur.avro.realtime.siri.model.VehicleActivityRecord;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JsonWriter {
    private static final DatumWriter<EstimatedVehicleJourneyRecord> etWriter = new SpecificDatumWriter<>(EstimatedVehicleJourneyRecord.class);
    private static final DatumWriter<VehicleActivityRecord> vmWriter = new SpecificDatumWriter<>(VehicleActivityRecord.class);
    private static final DatumWriter<PtSituationElementRecord> sxWriter = new SpecificDatumWriter<>(PtSituationElementRecord.class);


    public static String write(EstimatedVehicleJourneyRecord body) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        write(body, stream);

        return new String(stream.toByteArray());
    }

    public static void write(EstimatedVehicleJourneyRecord body, OutputStream stream) throws IOException {
        Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(
                EstimatedVehicleJourneyRecord.SCHEMA$, stream);
        etWriter.write(body, jsonEncoder);
        jsonEncoder.flush();
    }

    public static String write(VehicleActivityRecord body) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        write(body, stream);

        return new String(stream.toByteArray());
    }

    public static void write(VehicleActivityRecord body, OutputStream stream) throws IOException {
        Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(
                VehicleActivityRecord.SCHEMA$, stream);
        vmWriter.write(body, jsonEncoder);
        jsonEncoder.flush();
    }

    public static String write(PtSituationElementRecord body) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        write(body, stream);

        return new String(stream.toByteArray());
    }

    public static void write(PtSituationElementRecord body, OutputStream stream) throws IOException {
        Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(
                PtSituationElementRecord.SCHEMA$, stream);
        sxWriter.write(body, jsonEncoder);
        jsonEncoder.flush();
    }
}
