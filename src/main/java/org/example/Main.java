package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            List<Process> process =  new ProcessBuilder().startPipeline(List.of(new ProcessBuilder("ls","/home/alireza"),new ProcessBuilder("grep","-i","username")));
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(
                    process.get(1).getInputStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}