package gson_serialize;

// import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Modifier;


class User {
  final String firstName;
  final String lastName;
  final transient Address address;

  public User(String firstName, String lastName, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }
}

class Address {
  final String state;
  final int zip;

  public Address(String state, int zip) {
    this.state = state;
    this.zip = zip;
  }
}

public class App {

  public static JsonObject prepare(Gson b, User u) {
    JsonObject joUser = b.toJsonTree(u).getAsJsonObject();
    JsonObject joAddr = b.toJsonTree(u.address).getAsJsonObject();
    for (String key : joAddr.keySet()) { joUser.add(key, joAddr.get(key)); }
    return joUser;
  }

  public static void main(String[] args) throws IOException {
    try (PrintStream prs = new PrintStream(System.out, true, "UTF8")) {
      Gson gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.TRANSIENT)
        // .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();
      
      User user = new User("Peter", "Flemming", new Address("NC", 27603));

      Object objToBeSerialized = prepare(gson, user);
      gson.toJson(objToBeSerialized, prs);

      System.out.println();
    }
  }
}
