# 문자열 덧셈 계산기

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

**입력**

- 구분자와 양수로 구성된 문자열

**출력**

- 덧셈 결과

```
결과 : 6
```

**실행 결과 예시**

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

## 구현 기능 목록

- Printer Class
    - `private static final String START_SENTENCE = "덧셈할 문자열을 입력해 주세요.";`을 인스턴스 변수로 가진다.
    - `private static final String RESULT_PREFIX = "결과 : "`을 인스턴스 변수로 가진다.
    - 기능
        - startSentence() : 시작 문구 문자열 반환
        - resultSentence(Integer sum) : "결과 : " + 합계 문자열 반환

- 문자열 입력
    - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

- InputParser Class
    - 문자열을 파싱하여 List<PositiveNumber> 형태로 반환한다.
    - 지원 구분자
        - 기본 구분자: 쉼표(,), 콜론(:)
        - 커스텀 구분자: "//"와 "\n" 사이에 위치한 문자
          예: "//;\n1;2;3" → ;를 구분자로 사용
    - 기능
        - parse(String input) : 문자열 전체를 파싱하여 양수 리스트 반환
        - 구분자 기준으로 분리 후, 숫자만 포함되어 있는지 검증
        - 숫자가 아닌 문자가 포함된 경우 IllegalArgumentException 발생
        - 빈 문자열("", " ", "//;\n")은 List.of() 반환

- PositiveNumber Class
    - 역할: 양수만을 표현하는 값 객체(Value Object)
    - private final int value
    - 생성자에서 0 이하의 값 입력 시 IllegalArgumentException 발생
    - getValue() : 값을 반환
    - addTo(int sum) : 현재 값을 기존 합에 더해 반환 (optional behavior)

- PositiveNumbers Class
    - 역할: List<PositiveNumber>를 포장한 일급 컬렉션
    - private final List<PositiveNumber> values
    - 기능
        - sum() : 모든 양수의 합 반환
        - 불변 컬렉션으로 관리하며 외부 변경 불가

- 조건을 만족하지 않는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.