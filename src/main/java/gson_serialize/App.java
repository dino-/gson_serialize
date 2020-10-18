package gson_serialize;

// import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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

/*
  public static JsonObject combine(JsonObject oLeft, JsonObject oRight) {
    JsonObject oNew = oLeft.deepCopy();
    for (String key : oRight.keySet()) { oNew.add(key, oRight.get(key)); }
    return oNew;
  }
*/

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
        .create();
      
      User user = new User("Peter", "Flemming", new Address("NC", 27603));

/*
      JsonObject userO = gson.toJsonTree(user).getAsJsonObject();
      JsonObject addrO = gson.toJsonTree(user.address).getAsJsonObject();
      gson.toJson(combine(userO, addrO), prs);
*/

      Retrofit retrofit = new Retrofit(prs, gson);
      retrofit.sendObject(prepare(gson, user));
    }
  }
}

class Retrofit {

  private final PrintStream prs;
  private final Gson gson;

  public Retrofit(PrintStream prs, Gson gson) {
    this.prs = prs;
    this.gson = gson;
  }

  public void sendObject(Object o) { gson.toJson(o, prs); }

}
