package annotation;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;


/** Cache
 * 사용 목적 : 서버의 부담을 줄이고, 성능을 높이기 위해 사용하는 기술,, 반복적으로 동일한 결과를 반환하는 경우 용이
 * Spring의 캐시 추상화
 *  - 스프링은 AOP 방식으로 메소드에 캐시 서비스를 적용하는 기능을 제공함
 *  - 트랜잭션과 마찬가지로 AOP를 이용해 메소드 실행 과정에 투명하게 적용됨.
 *  - 캐시관련 로직을 핵심 비즈니스 로직으로부터 분리할 뿐만 아니라, 손 쉽게 캐시 기능을 적용 가능
 */

@EnableCaching // 어노테이션 기반의 캐시 기능을 사용하기 위한 별도의 선언
public class Cache {


    /**
     * 어노테이션을 추가한 후, 캐시를 관리해줄 CacheManager를 빈으로 등록시켜야 함,
     * Spring에서 제공하는 캐시 매니저들
     *  - ConcurrentMapCacheManager : Java의 ConcurrentHashMap을 사용해 구현한 캐시를 사용하는 캐시매니저
     *  - SimpleCacheManager : 기본적으로 제공하는 캐시가 없어, 사용할 캐시를 직접 등록하여 사용하기 위한 캐시매니저
     *  - EhCacheCacheManager : 자바에서 유명한 캐시 프레임워크중 하나인 EhCache를 지원하는 캐시매니저
     *  - CompositeCacheManager : 1개 이상의 캐시매니저를 사용하도록 지원해주는 혼합 캐시매니저
     *  - CaffeineCacheManager : Java8로 Guava 캐시를 재작성한 Caffeine 캐시를 사용하는 캐시매니저
     *  - JCacheCacheManager : JSR-107 기반의 캐시를 사용하는 캐시매니저
     *
     *  Redis Cache를 사용하기 위해선 RedisCacheManager를 사용,,
     */

    /**
     * @Cacheable
     * 클래스나 인터페이스에도 캐시를 지정 할 수 있으나 이렇게 작업하는 경우는 상당히 드물음
     * 보통은 메서드 단위로 적용, 캐시를 적용할 메서드에 @Cacheable 어노테이션을 붙여 사용
     * 캐시에 데이터가 없는 경우 기존 로직을 실행 한 후 캐시에 데이터를 추가, 캐시에 데이터가 있으면 캐시의 데이터를 반환한다.
     * 파라미터가 없으면 0이라는 디폴트 값이 캐시의 Key로 저장, 파라미터 여러개면 파라미터의 hashCode 값을 조합하여 키를 생성
     * 별도의 키값을 설정하고싶으면 @Cacheable(value="값", key = "#키값") 을 통해 지정 (SpEL 사용,, 파라미터가 객체라면 reference를 통해 하위 속성에 접근 가능)
     * 특정 조건인 경우에 캐시를 적용하기 윈하면 condition 속성 사용
     */

    /**
     * @CachePut
     * 캐시에 값을 저장하는 용도로만 사용, 조회 시 저장된 캐시의 내용을 사용하지는 않고, 항상 메서드의 로직을 실행함.
     */

    /**
     * @CacheEvict
     * 캐시는 적절한 시점에 제거해야 하는데, 캐시를 제거하는 방법
     *  - 일정한 주기로 캐시를 제거
     *  - 값이 변할 때 캐시를 제거
     *  @CacheEvict는 기본적으로 메소드의 키에 해당하는 캐시만 제거함. 캐시에 저장된 모든 값을 제거할 필요가 있다면, allEntries 속성을 true로 지정해준다.
     */






}
