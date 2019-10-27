package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String[][]> departmentMap = new HashMap<>();
        Map<String, TreeSet<String>> doctorAndPatients = new HashMap<>();

        String input = reader.readLine();
        while (!"Output".equals(input)) {
            String[] tokens = input.split("\\s+");
            String department = tokens[0];
            String doctorName = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new String[20][3]);
            }
            boolean patientAdded = false;
            for (int i = 0; i < departmentMap.get(department).length; i++) {
                for (int j = 0; j < departmentMap.get(department)[i].length; j++) {
                    if (departmentMap.get(department)[i][j] == null) {
                        departmentMap.get(department)[i][j] = patient;
                        patientAdded = true;
                        break;
                    }
                }
                if (patientAdded) {
                    break;
                }
            }
            if (!doctorAndPatients.containsKey(doctorName)) {
                doctorAndPatients.put(doctorName, new TreeSet<>());
            }
            if (patientAdded) {
                doctorAndPatients.get(doctorName).add(patient);
            }


            input = reader.readLine();
        }
        input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 1) {
                String department = tokens[0];
//                Arrays.stream(departmentMap.get(department)).forEach(e->{
//                    Arrays.stream(e).filter(Objects::nonNull).forEach(System.out::println);
//                });
                for (int i = 0; i < departmentMap.get(department).length; i++) {
                    for (int j = 0; j < departmentMap.get(department)[i].length; j++) {
                        if (departmentMap.get(department)[i][j] != null) {
                            System.out.println(departmentMap.get(department)[i][j]);
                        }
                    }
                }
            } else if (tokens.length == 2) {
                if (Character.isDigit(tokens[1].charAt(0))) {
                    String department = tokens[0];
                    int room = Integer.parseInt(tokens[1]) - 1;
                    String [] patients = departmentMap.get(department)[room];
                    Arrays.stream(patients).filter(Objects::nonNull).sorted(String::compareTo).forEach(System.out::println);

                } else {
                    String doctor = tokens[0] + " " + tokens[1];
                    doctorAndPatients.get(doctor).forEach(System.out::println);
                }
            }
            input = reader.readLine();
        }
    }
}
