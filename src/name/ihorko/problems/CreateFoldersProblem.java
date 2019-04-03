package name.ihorko.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CreateFoldersProblem {

    public static void main(String[] args) throws IOException {
        createProblemFolders(26, 31);
    }

    static void createProblemFolders(int from, int to) throws IOException {
        ArrayList<String> folderNames = getNamesOfProblems(from, to);
        for (String s:folderNames) createFolder("src\\name\\ihorko\\problems", s);
    }
    static boolean createFolder(String path, String name) {
        return new File(path + "\\" + name).mkdir();
    }
    static ArrayList<String> getNamesOfProblems(int from, int to) throws IOException {
        URL url;
        BufferedReader in;
        ArrayList<String> problemNames = new ArrayList<>();
        for (int i = from; i < to; i++) {
            url = new URL("https://projecteuler.net/problem=" + i);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("<h2>")) {
                    problemNames.add(
                            String.format(
                                    "problem_%03d__%s",
                                    i, inputLine.substring(
                                            inputLine.indexOf("<h2>")+4,
                                            inputLine.indexOf("</h2>")
                                    ).replace(" ", "_").replace("-", "_")
                            )
                    );
                }
            }
            in.close();
        }
        return problemNames;
    }
}
