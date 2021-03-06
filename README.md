# numbaseball-java

자바로 구현한 숫자야구 게임

## 개요

숫자야구 게임은 [Bulls and Cows][]를 원형으로 하는 알아맞추기 게임의 일종입니다. 여러 프로그래밍 학습에서 숫자야구 게임을 실제로 구현해보는 연습 문제를 제공하고 있으며, 소프트웨어 개발자 국비교육과정에서도 숫자야구 게임의 구현이 평가 과제로 제시된 바 있습니다.

[Bulls and Cows]: https://en.wikipedia.org/wiki/Bulls_and_Cows

이 프로그램은 숫자야구 게임을 자바로 구현한 것입니다. 개발 환경으로는 [Amazon Corretto 8][]을 사용하였으며 [Apache Maven 3][], [Lombok][]을 사용하였습니다.

[Amazon Corretto 8]: https://aws.amazon.com/ko/corretto/
[Apache Maven 3]: https://maven.apache.org/
[Lombok]: https://projectlombok.org/

## 규칙

* 플레이어는 0부터 9까지 임의의 한 자리 숫자 3개를 알아맞춰야 합니다.
* 플레이어에게 주어진 기회는 총 9회이며, 기회를 모두 소진하면 게임에서 패배합니다.
* 플레이어가 입력한 숫자가 컴퓨터가 생성한 정답 중에 포함되어 있고 위치가 같을 경우, 스트라이크 판정을 얻습니다. 한 시도 내에서 3스트라이크 판정을 얻으면 게임을 승리합니다.
* 플레이어가 입력한 숫자가 컴퓨터가 생성한 정답 중에 포함되어 있지만 위치가 다를 경우, 볼 판정을 얻습니다.
* 플레이어가 입력한 숫자가 컴퓨터가 생성한 정답 중에 포함되어 있지 않으면, 아웃 판정을 얻습니다.
* 시도 중 3아웃 판정을 얻으면, 게임에서 패배합니다.

## 커맨드라인 사용

본 저장소를 클론한 뒤 프로그램을 빌드하고 구동하기 위해 해당 디렉토리에 진입하여 다음 명령어를 실행합니다(Maven이 PATH에 등록되어 있다고 가정합니다).

```
mvn clean
mvn package
java -jar ./target/numbaseball.jar
```

## TODO

아직 이 프로젝트에서 작업이 이루어지지 않은 부분은 다음과 같습니다.

* 멀티플레이
* 테스트 작성

그 외 다른 개선해야 할 요소들이 있을 수 있습니다.
