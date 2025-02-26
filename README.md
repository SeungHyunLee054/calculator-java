# 계산기

## 기능
### 1. 계산 기능
- \+ : 더하기
- \- : 빼기
- / : 나누기
- % : 나머지
- ^ : 거듭제곱
- log : 로그
### 2. 계산 결과값을 저장하고 가장 큰 값을 출력하는 기능
### 3. 저장된 결과값 중 가장 먼저 저장된 데이터를 삭제하는 기능

## 기능 Flow
1. Scanner를 통해 정수 또는 실수 값을 입력 받는다.(숫자를 입력하지 않으면 Exception 발생 -> catch문에서 처리, exit 입력 시 프로그램 종료)
2. Generic으로 Number class를 extends하여 정수 또는 실수값을 입력하여도 계산이 가능
3. Scanner를 통해 연산자를 입력받는다(Enum으로 연산자를 관리 옳바르지 않은 연산자를 입력하면 Exception 발생 -> catch문에서 처리, exit 입력 시 프로그램 종료)
4. Calculator class에서 입력받은 숫자와 연산자를 switch문으로 구분하여 계산, 결과값 저장 및 반환(나누기, 나머지의 분모에 0이 들어왔을 때, log 계산에 0이 들어왔을 때 Exception 발생 -> catch문에서 처리)

## 트러블 슈팅
1. enum을 활용하는 데 막힘이 있었다.
    - 연산자를 입력받을 때 enum class 내부에서 정의된 enum 값과 입력받은 연산자가 일치하는지 확인하는 메서드를 만들고 일치하지 않는 경우는 exception을 발생 시킴
    - try-catch문으로 감싸줬기 때문에 오류 발생으로 종료되지 않고 catch문에서 연산자의 값이 틀렸다는 문장과 함께 continue 시킴
2. generic을 활용하는 데 막힘이 있었다.
    - 입력값이 string 타입인데 이 값이 Integer인지 Double인지 확인하는 작업과 이 것을 어떻게 변수로 받아 calculator class로 넘길지에 대한 문제가 발생하였다.
        - calculator class에 generic T로 변수를 선언하여 변수를 입력받았다.
            - Number class를 generic에 extends 시켜 해당 클래스의 하위의 타입이 올 것이라고 범위를 좁힘
        - calculator class로 변수를 넘기기 전 입력받은 값을 Number로 형변환 시켜서 넘겨주었다.
            - 이 형변환 과정에서 parsing class를 생성하여 입력값에 ‘.’이 있다면 Double로 없다면 Integer로 변환하여 Number 형의 변수로 담아줌
        - 결과 값을 반환할 때 generic T로 반환시킬 때 마땅한 방법을 찾지 못하여 값을 계산하는 식이 doubleValue()로 형변환하여 계산하기 때문에 Double.valueOf()를 통해 wrapper 클래스로 변환 후 (T)로 강제 형변환을 하여 반환해 주었다.
3. calculator class의 계산을 하는 부분인 calculate 메서드에서 연산자를 case조건으로 switch문을 사용하는 부분이 있는데 해당 부분을 메서드로 변경 및 분리를 고려
    - 객체지향적 관점에서 부합하지 않는 결과였기 때문에 변경을 하지 않음
    - calculator class는 기능적 코드를 갖지 않고 기능 클래스를 별도로 작성하여 calculator에서 해당 기능 클래스를 가져오는 방법이 객체지향적 관점에서 더욱 부합하다고 알게됨
      - 개인적인 생각으로 현재 코드의 덩치?에서는 위와 같은 방법의 기능 분리는 불필요하다고 생각하여 수정은 하지 않음
4. generic을 사용하여 변수를 받고 해당 값을 double로 변환하여 계산하는 부분에서 변환하지 않고 계산하는 방법이 있는지에 대한 고려
    - Number는 추상 클래스이기 때문에 직접 계산이 불가능
    - 추가 기능으로 거듭제곱과 로그 계산 기능을 추가하였기 때문에 Math 클래스를 사용하기 위해선 double로 변경하는 과정이 필수라 해당 문제는 해결
