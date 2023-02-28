package json;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Cookies {
       /**
         * Cookie
         *  - 클라이언트에 저장되며, Key와 Value로 이루어진 데이터
         *  - 주로 서버에서 생성하여 Set-Cookie HTTP Response Header에 넣어 클라이언트에게 전달하고, 클라이언트에서 직접 쿠키에 데이터를 저장 할 수있다.
         *  - 사용자가 별다른 컨트롤 없이 Request시 자동으로 브라우저가 Request Header를 넣어 서버에 전송한다.
         *  - 만료기간을 설정할 수 있으며, 만료기간 전까지 브라우저가 종료되어도 삭제되지 않는다.
         *
         *  - key=Value 쌍으로 구성되고, path,expires등의 속성을 가지며 ;로 구분된다.
         *   >> key=value;path=경로; expires=만료날짜; domain=도메인; secure; httpOnly
         *   속성
         *      - path
         *          - 특정 경로에서만 쿠키를 활성화시키는 속성, 다른 경로에 있으면 cookie를 확인 할 수 없다.
        *           - 미설정시Response Header에 담아 응답하지만, 브라우저에 저장하지 않는다.
         *      - domain
         *          - 쿠키가 전송되어질 서버 도메인을 지정하는 속성
         *          - 도메인을 설정한 경우 해당 도메인 및 하위 도메인에서만 쿠키에 접근할 수 있다.
         *      - expires
         *          - 쿠키의 만료기간을 의미하고, 만료기간이 지나면 자동삭제됨
         *          - 만료기간 전 까지는 자동으로 삭제가 되지 않는다
         *      - secure
         *          - 해당 속성 사용시, HTTPS 통신이 아니면 서버로 쿠키를 전송하지 않는다.
         *          - HTTP 통신시 쿠키를 암호화 하지 않은 상태로 서버로 전달하기 때문에 보안상 secure 속성을 설정하는것이 좋다.
         *      - httpOnly : 해당 속성 사용시, 지정된 쿠키는 서버와 통신 할 때만 정보를 확인 할 수 있고, js로 document.cookie에 접근하여 쿠키정보를 조회 할 수 없다.
         */

       /**
        * 쿠키 값 설정하기(클라이언트에게 보내기)
        * @param response
        */
       @RequestMapping("/cookie")
       @ResponseBody
       public void addCookie(HttpServletResponse response){
              Cookie cookie = new Cookie("key","value");
              cookie.setPath("/");
              response.addCookie(cookie); // 응답에 쿠키를 담아 클라이언트에게 응답,, Response Header에 담아 보냄
       }

       /**
        * 서버로부터 쿠키 값 받기
        * @param request
        */
       @RequestMapping("/cookie/send")
       public void sendCookie(HttpServletRequest request){
              Cookie[] cookies = request.getCookies();
              int i = 0;
              for (Cookie cookie : cookies) {
                     System.out.println(i+"번째 쿠키의 key = " + cookie.getName());
                     System.out.println(i+"번째 쿠키의 val = " + cookie.getValue());
                     i++;
              }
       }

       /**
        * 쿠키 속성 설정하기
        * Expire, Domain
        */
       @RequestMapping(value = "cookie/expires", method= RequestMethod.GET)
       public void cookieSend(HttpServletResponse response){
              Cookie cookie = new Cookie("super","joo");
              cookie.setPath("/super"); // url경로가 /super 또는 /super 하위 경로인 경우에만 쿠키 정보를 확인 가능
              cookie.setMaxAge(60*60*24*365); // 만료기간 1년 설정 (단위는 sec) -1 설정시 브라우저 종료시에 쿠키 만료처리
              cookie.setDomain("superman.com");// 도메인이 superman.com 또는 서브 superman도메인 에서 해당 쿠키 정보에 접근이 가능
              response.addCookie(cookie);
       }
}
