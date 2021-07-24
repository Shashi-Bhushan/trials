package in.shabhushan.stateless;

import org.apache.flink.api.common.io.FilePathFilter;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;

/**
 * This program demonstrates
 * 1. How to start a Flink Cluster from java program, that is accessible on port 8081
 * 2. Read from file continuously after certain interval of time
 * 3. Output to another file continuously
 */
public class ContinuousStreaming {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.setInteger(RestOptions.PORT, 8081);

        ParameterTool params = ParameterTool.fromArgs(args);

        // Connect to local Flink Cluster
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(1, conf);
        env.getConfig().setGlobalJobParameters(params);

        DataStream<String> stream;

        if (!params.has("input") || !params.has("output")) {
            System.out.println("Use --input to specify file input");
            System.out.println("ANS");
            System.out.println("Use --output to specify file output");

            System.exit(1);
            return;
        }

        String input = params.get("input");
        String output = params.get("output");

        TextInputFormat format = new TextInputFormat(new Path(input));
        // scan all files in the directory `path` for change
        format.setFilesFilter(FilePathFilter.createDefaultFilter());

        DataStream<String> inputStream = env.readFile(format, input, FileProcessingMode.PROCESS_CONTINUOUSLY, 5000);

        SingleOutputStreamOperator<String> headerStream = inputStream.filter(i -> i.startsWith("RIO"));

        SingleOutputStreamOperator<String> filterData = inputStream.filter(i -> i.contains("Gold:0"));

        DataStream<String> outputStream = headerStream.union(filterData);

        StreamingFileSink<String> sink = StreamingFileSink.forRowFormat(new Path(output), new SimpleStringEncoder<String>("UTF-8")).build();
        outputStream.addSink(sink);
        outputStream.print();

        env.execute("Processing File Continuously");
    }
}
