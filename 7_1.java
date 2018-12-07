import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Character.*;

public class aoc {
    public static void main(String[] args) throws Exception {
        Map<String, TreeSet<String>> data = new ConcurrentHashMap<>();

        List<String> input = Files.readAllLines(new File("/Users/vrashabhirde/Desktop/aoc/input7.txt").toPath());
        List<String> sanitized = new ArrayList<>();
        List<String> desanitized = new ArrayList<>();
        for (String str : input) {
            sanitized.add(str.split(" ")[7]);
            sanitized.add(str.split(" ")[1]);
            desanitized.add(str.split(" ")[7] + str.split(" ")[1]);
        }

        Set<String> foo = new HashSet<>(sanitized);
        for (String str : foo) {
            data.put(str, new TreeSet<>());
        }
        for (String str : desanitized) {
            String s[] = str.split("");
            TreeSet<String> set = data.get(s[0]);
            set.add(s[1]);
            data.put(s[0], set);

        }

        while (data.size() > 0) {
            for (Map.Entry<String, TreeSet<String>> entry : data.entrySet()) {
                if (entry.getValue().size() == 0) {
                    System.out.print(entry.getKey());
                    data.remove(entry.getKey());
                    for (Map.Entry<String, TreeSet<String>> e : data.entrySet()) {
                        TreeSet<String> an = e.getValue();
                        an.remove(entry.getKey());
                        data.put(e.getKey(), an);
                    }
                    break;
                }
            }
        }

    }

}
