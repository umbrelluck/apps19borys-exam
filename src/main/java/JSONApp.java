import domain.BasicStudent;
import domain.Student;
import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }


    public static JsonObject sessionResult() {
        JsonObject jsonObject;
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));

        JsonObject oop = new JsonObject();
        oop.add(new JsonPair("course", new JsonString("OOP")));
        oop.add(new JsonPair("mark", new JsonNumber(3)));
        oop.add(new JsonPair("passed", new JsonBoolean(true)));

        JsonObject eng = new JsonObject();
        eng.add(new JsonPair("course", new JsonString("English")));
        eng.add(new JsonPair("mark", new JsonNumber(5)));
        eng.add(new JsonPair("passed", new JsonBoolean(true)));

        JsonObject math = new JsonObject();
        math.add(new JsonPair("course", new JsonString("Math")));
        math.add(new JsonPair("mark", new JsonNumber(2)));
        math.add(new JsonPair("passed", new JsonBoolean(false)));

        Json jMarks = new JsonArray(oop, eng, math);
        JsonPair marks = new JsonPair("exams", jMarks);

        JsonPair year = new JsonPair("year", new JsonNumber(2));

        jsonObject = new JsonObject(name, surname, year, marks);

        return jsonObject;
    }
}
