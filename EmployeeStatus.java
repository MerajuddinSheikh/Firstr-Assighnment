package employeeRecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeStatus {
    public static void main(String[] args) throws Exception {
        int count = 0;
        String lines = " ";
        FileReader fr = new FileReader("A:\\file2.txt");
        BufferedReader br = new BufferedReader(fr);
        String Line = br.readLine();
        while ((Line != null)) {

            StringTokenizer Tokan1 = new StringTokenizer(Line, " ,");

            while (Tokan1.hasMoreElements()) {
                EmployeeWork company = new EmployeeWork();

                String Number = company.Number(Tokan1.nextToken());
                //nt Number= company.Number(Integer.parseInt(String.valueOf(Tokan1)));
                String Name = company.Name(Tokan1.nextToken());
                String Login = company.Login(Tokan1.nextToken());
                DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                Date date = sdf.parse(Login);

                //System.out.println("Time: " + sdf.format(date));
                String Logout = company.Logout(Tokan1.nextToken());
                DateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
                Date date2 = sdf1.parse(Logout);
                // System.out.println(("Time: " + sdf1.format(date2)));
                long diff = date2.getTime() - date.getTime();
                // long diff = date2.getTime() - date.getTime();

                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                Map<String, Long> map = new HashMap<>();
                map.put(Number, diffHours);


                TreeMap<String, Long> sorted = new TreeMap<>(map);

                // Display the TreeMap which is naturally sorted
                for (Map.Entry<String, Long> entry : sorted.entrySet())
                    //  System.out.println("Key = " + entry.getKey() +
                    //  ", Value = " + entry.getValue());

                    // System.out.println(sorted.keySet());
               /* Map<String, Long> result2 = new LinkedHashMap<>();
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));*/

                    // map.keySet();
                    //System.out.println(result2.keySet());

                    if (diffHours > 8 && diffMinutes >= 0 || diffSeconds >= 0) {

                        //System.out.println("employee is present and hours,minutes and seconds are"   +Name + " "+  diffHours  + " " + diffMinutes + " " + diffSeconds);
                        count++;
                    } else {
                        // System.out.println("employee is present only for hours, minutes and seconds " +  diffHours  + " " + diffMinutes  + " " + diffSeconds);
                        count++;
                    }


                //   System.out.print(diffHours + " hours, ");
                //  System.out.print(diffMinutes + " minutes, ");
                // System.out.print(diffSeconds + " seconds.");


                //  System.out.println(difference);


                //String Publisher=library.PublisherName(Tokan1.nextToken());
                // String year1=library.Year(Tokan1.nextToken());
                System.out.println("id name hours,counts ");

                System.out.println(Number + " " + Name + " " + diffHours + " " + count);
                //System.out.println("Number of Occurrence of the Element:"+count);


            }
            Line = br.readLine();


        }

        br.close();
        fr.close();


    }
}
