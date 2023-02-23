package annotation;

public class Value {
    public static void main(String[] args) {
        /**
         * 외부에서 특정 값들을 주입받아야 하는 경우 (소스 코드에 하드코딩시 탈취하면 위험함,,)
         * applications.properties 혹은 application.yml등 외부 설정값들을 관리하는 파일에 적어두고 사용하기도 하고 ,
         * .jar파일을 실행하기위한 커맨드에서 직접 값을 넘겨주기도 함.
         * 스프링에서 텍스트 파일로 변수 값들을 선언하고 싶을 때(변수 값을 프로퍼티라고 함)
         *
         * @Value 어노테이션에 값을 가리키고있는 placeholder를 명시해주거나, SpEL을 명시해준다.
         * - 불변이 아니기 때문에 값이 변경될 위험성에 노출되어있음,,
         */
    }
}
