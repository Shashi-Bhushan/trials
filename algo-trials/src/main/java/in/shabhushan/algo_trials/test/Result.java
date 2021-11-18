package in.shabhushan.algo_trials.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Result {
  public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
    Result result = new Result();

    result.apiResponseParser(List.of("username", "EQUALS", "Garimag"), 0);
  }

  static List<User> users;

  public Result() throws IOException {
    URLConnection connection = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users").openConnection();
    connection.setRequestProperty("Accept-Charset", "UTF-8");
    InputStream response = connection.getInputStream();

    String responseBody = "";

    try (Scanner scanner = new Scanner(response)) {
      responseBody = scanner.useDelimiter("\\A").next();
    }

    Gson gson = new Gson();

    this.users = gson.fromJson(responseBody, new TypeToken<List<User>>() {
    }.getType());
  }

  public static List<Integer> apiResponseParser(List<String> inputList, int size) throws NoSuchFieldException, IllegalAccessException {
    List<Integer> output = new ArrayList<>();

    String operation = inputList.get(1);

    if (operation.equals("IN")) {
      String[] nodes = inputList.get(0).split("\\.");

      for (User user: users) {
        for (String node : nodes) {
          Field field = user.getClass().getDeclaredField(node);

          Object o = field.get(user);
          System.out.println(o);
        }
      }

      //
      String[] values = inputList.get(2).split(",");
    } else {
      String[] nodes = inputList.get(0).split("\\.");

      for (User user: users) {
        for (String node : nodes) {
          Field field = user.getClass().getDeclaredField(node);

          String o = (String) field.get(user);

          String value = inputList.get(2);

          if (value.equalsIgnoreCase(o)) {
            output.add(user.id);
            break;
          }
        }
      }
    }

    return output;
  }
}

class User {
  int id;
  String name;
  String username;
  String email;
  Address address;
  String website;
  Company company;
}

class Address {
  String street;
  String suite;
  String city;
  String zipcode;
  LatLong latLong;
}

class LatLong {
  String lat;
  String lng;
}

class Company {
  String name;
  String basename;

  public Company(String name, String basename) {
    this.name = name;
    this.basename = basename;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBasename() {
    return basename;
  }

  public void setBasename(String basename) {
    this.basename = basename;
  }
}
