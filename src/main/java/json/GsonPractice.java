package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GsonPractice {
    public static void main(String[] args) {

        /**
         * GSON : Json 구조를 띄는 직렬화된 데이터를 java의 객체로 직렬화, 역직렬화 해주는 구글의 라이브러리
         */

        JSONObject jo = new JSONObject();
        jo.put("nickName","ailiartsua");
        jo.put("name","LeeJuho");
        jo.put("age","27");
        jo.put("birth","1997-03-27");

        /**
         * GSON 객체 생성 방법
         * 1. 단순히 new Gson()만 사용,
         * 2. new GsonBUilder.create() 사용
         *  - 옵션을 사용 할 수 있음
         *      - setPrettyPrinting : JSON 객체로 변환시 예쁘게 글자를 출력 할 수 있다.
         */
        Gson gson1 = new Gson();
        Gson gson2 = new GsonBuilder().create();
        Gson gson3 = new GsonBuilder().setPrettyPrinting().create();

        /**
         * 메서드
         * - toJson : Gson객체를 Json 문자열로 반환
         * - fromJson : Json 문자열을 객체로 변환
         *  - map과 변환도 가능하다.
         *  - Gson은 값이 null인 property는 생성하지 않는다.
         *  - 필드에 transient를 붙이면 serialize 하면서 해당 필드를 제외시킬 수 있다.
         *  - 또는 @Expose(serialize = true, deserialize = false)로 옵션을 주어 필드를 추가 제거 할 수 있다.
         */

        String jsonStr = gson1.toJson(jo); // JsonObject를 Json문자열로 변환
        System.out.println("jsonStr = " + jsonStr);

        String strJson = "{\"name\":\"이주호\",\"amount\":123}";
        Product product = gson2.fromJson(strJson, Product.class); // Json 문자열을 java Object로 변환

        Map<String,String> map = new HashMap<>();
        map.put("name","김치국");
        map.put("amount","15");
        String mapStr = gson3.toJson(map); // Map >> Json 변환
        System.out.println("mapStr = " + mapStr);

        String strJson2 = "{\"name\":\"김흥국\",\"amount\":3}";
        Gson gson = new Gson();
        Map<String,Object> map2 = gson.fromJson(strJson2, Map.class); // Json 문자열을 Map으로 변환
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        /**
         *  transient인 num은 미출력
         *  @Expose로 serialize false, deserialize true인 name은
         *  객체 > Json시에는 제외,
         *  Json > 객체시에는 포함.
         */
        Student student = new Student(327,"이주호");
        Gson gson4 = new Gson();
        String strGson = gson4.toJson(student);
        System.out.println("strGson = " + strGson);

    }


    public static class Student{
        private transient int num;

        @Expose(serialize = false, deserialize = true)
        private String name;

        public Student(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Product{
        private String name;
        private int amount;

        public Product(String name, int amount) {
            this.name = name;
            this.amount = amount;
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
    }
}
