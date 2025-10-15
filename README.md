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
    - `private static final String startSentence = "덧셈할 문자열을 입력해 주세요.";`을 인스턴스 변수로 가진다.
    - `private static final String resultPrefix = "결과 : "`을 인스턴스 변수로 가진다.
    - `BufferedWriter`를 인스턴스 변수로 가진다.
    - printStartSentence(): startSentence를 출력
    - printResultSentence(Double sum): resultPrefix + sum 출력

- 덧셈할 문자열 입력
    - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

- InputParser Class
    - 쉼표(,) 또는 콜론(:)을 구분자로 파싱
    - 커스텀 구분자로 파싱
        - 커스텀 구분자: "//"와 "\n" 사이에 위치하는 문자
        - 커스텀 구분자로 파싱하는 경우 모든 구분자는 커스텀 구분자여야 한다.
    - 문자열 파싱 후, List<Number>로 숫자들을 반환

- PositiveNumber Class
    - isPositive(): Number가 양수인지 판단하는 메서드
    - 계산기에 사용할 수 있게 Double Type으로 변환
    - List<Number>를 인자로 갖고 List<PositiveNumber>를 반환하는 메서드

- Calculator Class
    - List<PositiveNumber> numbers를 인스턴스 변수로 가진 클래스
    - sum(): numbers의 합을 반환

- 조건을 만족하지 않는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.