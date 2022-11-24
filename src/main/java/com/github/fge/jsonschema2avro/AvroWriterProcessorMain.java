package com.github.fge.jsonschema2avro;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.AbstractProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.CanonicalSchemaTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.ValueHolder;
import org.apache.avro.Schema;

import java.io.IOException;

public class AvroWriterProcessorMain {

    public static void main(String[] args) throws IOException, ProcessingException {
        AvroWriterProcessor processor=new AvroWriterProcessor();

        //preparation of input json schema

        JsonNode jsonNode = JsonLoader.fromResource("/jsonschema2avroschema/arraysample.json");
        System.out.println("json schema: "+jsonNode);
        final SchemaTree jsonSchematree = new CanonicalSchemaTree(jsonNode);
        final ValueHolder<SchemaTree> inputJsonSchemaValueHolder = ValueHolder.hold("schema", jsonSchematree);


   //preparation of processingReport with required LogLevels
        ProcessingReport processingReport=new Report(LogLevel.INFO, LogLevel.FATAL);

      //method to convert from Json Schema to Avro Schema
        Schema avroSchema = processor.process(processingReport, inputJsonSchemaValueHolder).getValue();

        System.out.println("avro schema: "+avroSchema);
    }
}


class Report extends AbstractProcessingReport {
    public Report(LogLevel logLevel, LogLevel exceptionThreshold) {
        super(logLevel, exceptionThreshold);
    }

    @Override
    public void log(LogLevel level, ProcessingMessage message) {

    }
}
