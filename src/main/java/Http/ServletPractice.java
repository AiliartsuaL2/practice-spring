package Http;

public class ServletPractice {
    public static void main(String[] args) {
        /**
         * WAS가 웹 브라우져로부터 Servlet 요청을 받으면
         *  - 1. HttpServletRequest 객체를 생성하여 저장
         *  - 2. 웹브라우져에게 응답을 돌려줄 HttpServletResponse 객체를 생성(빈 객체)
         *  - 3. 생성된 HttpServletRequest(정보가 저장된)와 HttpServletResponse(비어있는)를 Servlet에게 전달
         */

        /**
         * HttpServletRequest
         *  - Request에 담겨있는 내용을 서블릿에서 파싱해서 개발자에게 전달해주는 목적,,
         *  - Http 프로토콜의 request 정보를 서블릿에게 전달하기 위한 목적으로 사용
         *  - Header정보, Parameter, Cookie, URI, URL 등의 정보를 읽어들이는 메소드를 가진 클래스
         *      - URL : 실제 파일의 위치(직접적인 파일의 경로,, http://exam/work/url.html)
         *      - URI : 파일의 위치를 알 수 있는 식별자, http://exam/uri(rewrite 기술을 사용하여 만든 의미있는 식별자)
         *  - 서버의 호스트 이름, 포트 번호, 클라이언트의 IP 주소, 포트 번호를 갖고있음
         *  - Body의 Stream을 읽어들이는 메소드를 가지고 있음
         *  - 위와 같은 다양한 요청정보를 HttpServletRequest 인터페이스의 getXXX 메서드를 통해 추출 할 수 있다. ServletRequest를 상속받는다.
         *  ServletRequest의 주요 메소드
         *          - Object getAttribute(String name) : ServletRequest 객체 안에 등록된 데이터를 추출하여 반환한다.
         *          - Enumeration getAttributeNames() : ServletRequest 객체 안에 등록된 데이터들의 이름 전부를 하나의 Enumeration 객체에 담아 반환한다.
         *          - String getCharacterEncoding() : 클라이언트가 서버에 서비스를 요청 할 때 사용한 문자들의 인코딩 문자셋을 반환한다.
         *          - int getContentLength() : 서비스 요청 시 보낸 요청 몸체에 포함된 데이터의 길이를 반환, 길이를 알 수 없을 때에는 -1을 반환
         *          - ServletInputStream getInputStream : 요청정보 몸체로부터 바이너리 데이터를 일기위해 한 번에 한 줄씩 있는 ServletInputStream 객체를 반환.
         *          - String getParameter(String name) : 클라이언트가 보낸 질의 문자열 중 인자로 지정된 name과 일치하는 것을 찾아 name의 value를 반환한다.
         *          - Enumeration<String> getParameterNames() : 클라이언트가 서버로 보낸 질의 문자열들의 이름을 하나의 Enumeration 객체에 담아서 반환한다.
         *          - String getParameterValues(String name) : 클라이언트가 서버로 보낸 질의 문자열 중 인자로 지정된 name과 일치하는 모든 값을 찾아 하나의 String 타입의 배열에 담아 반환한다.
         *          - BufferedReader getReader() : 요청정보 몸체로부터 문자 인코딩에 따라 텍스트를 읽어들이기 위한 BufferedReader 객체를 반환한다.
         *          - String getRemoteAddr() : 서버에 서비스를 요청한 클라이언트의 IP 주소를 반환한다.
         *          - String getScheme() : 서비스 요청시 사용한 http, https, ftp등과 같은 프로토콜 이름을 반환한다.
         *          - String getServerName() : 서비스를 요청 받은 서버의 이름을 반환한다.
         *          - int getServerPort() : 클라이언트의 서비스를 요청받은 서버 포트 번호를 반환한다.
         *          - ServletContext getServletContext() : 서버가 시작될 때 웹 애플리케이션 단위로 생성된 ServletContext 객체의 주소를 추출하여 반환한다.
         *          - void removeAttribute(String name) : ServletRequest 객체에 setAttribute(name)을 이용하여 등록된 데이터를 삭제한다.
         *          - void setAttribute(String name, Object o) : 클라이언트의 또 다른 서비스 요청에서도 계속 사용하고싶은 데이터를 ServletRequest 객체 안에 저장해준다.
         *          - void setCharacterEncoding(String env) : 클라이언트가 요청정보 몸체에 포함해서 보내주는 문자열들을 지정된 문자셋을 통해 인코딩해준다.
         *
         *
         *          - RequestMapping : value에 해당하는 url로 연결, method 없을시 GET으로 ,,
         */

        /**
         * HttpServletResponse
         *  - Servlet은 HttpServletResponse 객체에 Content Type, 응답코드, 응답 메세지 등을 담아서 전송함
         */

    }
}
