package org.entur.avro.realtime.siri.helper;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.entur.avro.realtime.siri.model.EstimatedVehicleJourneyRecord;
import org.entur.avro.realtime.siri.model.PtSituationElementRecord;
import org.entur.avro.realtime.siri.model.VehicleActivityRecord;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {
    private static final DatumReader<VehicleActivityRecord> vmReader = new SpecificDatumReader(VehicleActivityRecord.class);
    private static final DatumReader<EstimatedVehicleJourneyRecord> etReader = new SpecificDatumReader(EstimatedVehicleJourneyRecord.class);
    private static final DatumReader<PtSituationElementRecord> sxReader = new SpecificDatumReader(PtSituationElementRecord.class);

    public static VehicleActivityRecord readVehicleActivity(String json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                VehicleActivityRecord.SCHEMA$, json);

        return vmReader.read(null, jsonDecoder);
    }

    public static VehicleActivityRecord readVehicleActivity(InputStream json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                VehicleActivityRecord.SCHEMA$, json);

        return vmReader.read(null, jsonDecoder);
    }

    public static EstimatedVehicleJourneyRecord readEstimatedVehicleJourney(String json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                EstimatedVehicleJourneyRecord.SCHEMA$, json);

        return etReader.read(null, jsonDecoder);
    }

    public static EstimatedVehicleJourneyRecord readEstimatedVehicleJourney(InputStream json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                EstimatedVehicleJourneyRecord.SCHEMA$, json);

        return etReader.read(null, jsonDecoder);
    }

    public static PtSituationElementRecord readPtSituationElement(String json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                PtSituationElementRecord.SCHEMA$, json);

        return sxReader.read(null, jsonDecoder);
    }

    public static PtSituationElementRecord readPtSituationElement(InputStream json) throws IOException {

        Decoder jsonDecoder = DecoderFactory.get().jsonDecoder(
                PtSituationElementRecord.SCHEMA$, json);

        return sxReader.read(null, jsonDecoder);
    }
}
