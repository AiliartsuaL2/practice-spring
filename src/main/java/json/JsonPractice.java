package json;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

public class JsonPractice {
    public static void main(String[] args) {

        /**
         * JSONObject : JSON에서 key-value 쌍으로 데이터를 표현하는 객체
         * - 데이터 입력시 put(key,value) 형식으로 입력
         * - 데이터 출력시 JSONObject 객체.toString()으로 String 변환
         * - 사용하기위해 json 라이브러리 의존성 추가를 해야함
         */

        /**
         * map에 저장된 데이터를 JSON으로 변환 할 수 있다.
         * LinkedHashMap, TreeMap을 사용해도 HashMap으로 들어간다
         */

        Map<String, Object> map = new TreeMap<>();
        map.put("123","Hello");
        map.put("45","World");
        map.put("6","!!");

        JSONObject jo = new JSONObject(map);

        String s = jo.toString();
        System.out.println("s = " + s);

        /**
         * POJO(PlainOldJavaObject) 단순히 필드와 게터세터 메서드만 있는 클래스
         * POJO 객체로 JSONObject 생성이 가능하다.
         */

        Product apple = new Product("apple",5,"bkabak");
        JSONObject jo2 = new JSONObject(apple);

        String s1 = jo2.toString();
        System.out.println("s1 = " + s1);

        /**
         * value에 Array 타입이 들어 갈 수 있다.
         * JSONArray로 들어 갈 수 있고, JSONArray는 put(value)로 0개 이상의 데이터를 추가 할 수 있다.
         */
        JSONArray ja = new JSONArray();
        ja.put("Hello");
        ja.put("World");

        JSONObject jo3 = new JSONObject();
        jo3.put("name","ailiartsua");
        jo3.put("age",27);
        jo3.put("word",ja);

        System.out.println(jo3.toString());

        Object age1 = jo3.get("age");
        System.out.println("age1 = " + age1.getClass());

    }

    public static class Product{
        private String name;
        private int amount;

        private String bark;

        public Product(String name, int amount, String bark) {
            this.amount = amount;
            this.name = name;
            this.bark = bark;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getBark() {
            return bark;
        }

        public void setBark(String bark) {
            this.bark = bark;
        }
    }

}
