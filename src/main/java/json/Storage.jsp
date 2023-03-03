
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--
-->

<script>
    /**
     * Storage : 데이터 저장을 위한 브라우저 내의 저장공간, key=value 쌍으로 저장되고 , key를 기반으로 조회.
     *  - local Stroage와 Session Storage로 나뉨
     *  - value에는 문자열만 들어갈 수 있음, (객체로 저장시 JSON.stringify()를 사용해 문자열로 변환하여 저장하고 조회시 JSON.parse()를 통해 문자열을 객체로 변환시켜야함
     */

    const payload = { super: "pil" };

    localStorage.setItem("key",JSON.stringify(payload)); // localstorage에 객체를 문자열로 변환하여 넣어줌

    const data = localStorage.getItem("key"); // localStroage의 데이터를 가져옴 (값은 문자열 형태)
    const objData = JSON.parse(data); // 문자열 형태의 값을 객체로 변환

    localStorage.removeItem("key"); // 특정 key값 삭제
    localStorage.clear(); // 전부 비움
    /**
     * localStorage
     *  - 영구성 : 데이터 저장 후 브라우저 창을 닫거나 새로고침을 해도 데이터는 삭제되지 않고 유지된다.
     *      - 데이터 만료기간이 없기 때문에 만료기간을 설정 할 수 없음(Cookie와의 차이점)
     *      - 영구적으로 데이터가 저장되기 때문에 데이터를 삭제하기 위해서는 직접 삭제해야함.
     *      - 지속적인 데이터를 저장하기 좋지만, 로그인 정보같은 중요한 데이터는 절대 저장해선 안됨
     *  - 브라우저 세션간 공유가 가능 : 브라우저 새 창을 열어도 모두 같은 localStroage의 데이터를 갖고있음
     *  - localStorage에 저장한 데이터는 프로토콜, 도메인별로 구분한다
     *      - http의 저장된 데이터는 https에서 확인 불가
     *      - 도메인이 다른경우 데이터는 공유되지않고 구분됨.
     *  - 서버로 전송되지 않는다.
     *      - Cookie와 다르게 Storage는 네트워크 요청시 서버로 전송되지 않는다.
     *      - 네트워크 트래픽 비용을 줄여주기 때문에 단순한 저장소로 사용하기 좋다.
     */

    /**
     * sessionStorage : localStorage와 사용법 같음, 문자열만 저장,, 다른 타입은 문자열로 변환하여 저장하여야 함
     *  - 데이터가 세션 단위로 저장된다(조건적 휘발성)
     *      - sessionStorage에 저장된 데이터는 브라우저가 닫히는 순간 삭제된다.
     *      - 마찬가지로 데이터 만료기간을 설정 할 수 없고, 브라우저가 닫히기 전 삭제를 원한다면 js또는 브라우저에서 직접 삭제를 해야한다.
     *      - 브라우저 세션간 공유가 불가능하다.
     *      - 서버로 전송되지 않는다.
     *
     */

    sessionStorage.setItem("key2",JSON.stringify(payload));
    const data = JSON.parse(sessionStorage.getItem("key2"));

    /**
     * 실무에선 localStroage보단 sessionStroage 많이 사용,
     * 배열을 넣고 빼고 하는 작업,, 카테고리 이동 관련 개선,,
     */
    let tmpParam = {};
    let categoryArr = [];
    categoryArr = JSON.parse(sessionStorage.getItem("categoryArrayKey"));
    categoryArr.push(JSON.stringify(tmpParam));
    sessionStorage.setItem("categoryArrayKey",JSON.stringify(categoryArr));



</script>