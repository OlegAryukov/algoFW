package otus.algo.tester;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ConsoleTester {
    ITask iTask;
    String path;

    public ConsoleTester(ITask iTask, String path) {
        this.iTask = iTask;
        this.path = path;
    }

    public void runTest() throws IOException {
        Path pathF = Paths.get(this.path);
        List<Path> inputs = Files.walk(pathF)
                .filter(path1 -> path1.getFileName().toString().endsWith(".in"))
                .collect(Collectors.toList());
        Map<Integer, List<String>> mapIn = new HashMap<>();
        for (Path path : inputs) {
            mapIn.put(Integer.valueOf(path.toString()
                    .substring(path.toString().length() - 4, path.toString().length() - 3)), Files.readAllLines(path));
        }

        List<Path> outputs = Files.walk(pathF)
                .filter(path1 -> path1.getFileName().toString().endsWith(".out"))
                .collect(Collectors.toList());
        Map<Integer, List<String>> mapOut = new HashMap<>();
        for (Path path : outputs) {
            mapOut.put(Integer.valueOf(path.toString().substring(path.toString().length() - 5,
                    path.toString().length() - 4)), Files.readAllLines(path));
        }


        for (Map.Entry<Integer, List<String>> entry : mapIn.entrySet()) {
            System.out.println(runTest(entry.getValue(), mapOut.get(entry.getKey())));

        }
    }

    public boolean runTest(List<String> in, List<String> out) {
        try {
            List<String> data = in;
            String expect = out.get(0).trim();
            String actual = iTask.run(data);
            return actual.equals(expect);
        } catch (Exception e) {
            System.out.println();
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        ITask iTask = new StringLength();
        ConsoleTester tester = new ConsoleTester(iTask, "C:/MyJavaCode/Algo/algo-master/code/1. " +
                "Комбинаторика/0.String");
        tester.runTest();
    }
}
