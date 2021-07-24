package in.shabhushan.stateless;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * This program demonstrates a stateless operation (Splitting a Sentence into words) in Apache Flinks
 *
 * Use the following command to run the program
 * ./bin/flink run -c in.shabhushan.stateless.SplittingSentence /home/shashi/Desktop/projects/personal/flinktest/target/flinktest-1.0-SNAPSHOT.jar --host "localhost" --port 9090
 */
public class SplittingSentence {
    public static void main(String[] args) throws Exception {
        ParameterTool params = ParameterTool.fromArgs(args);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(params);

        DataStream<String> stream;

        if (params.has("input")) {
            System.out.println("Splitting sentences from a file");

            stream = env.readTextFile(params.get("input"));
        } else if (params.has("host") && params.has("port")) {
            System.out.println("Splitting sentences from a socket stream");

            stream = env.socketTextStream(params.get("host"), Integer.parseInt(params.get("port")));
        } else {
            System.out.println("Use --input to specify file input");
            System.out.println("OR");
            System.out.println("Use --host and --port to specify socket input");

            System.exit(1);
            return;
        }

        System.out.println("Source Initialized");

        stream.flatMap(new SentenceSplitter()).print();

        env.execute("splitting words");
    }

    public static class SentenceSplitter implements FlatMapFunction<String, String> {

        @Override
        public void flatMap(String s, Collector<String> out) throws Exception {
            for (String word : s.split(" ")) {
                out.collect(word);
            }
        }
    }
}
