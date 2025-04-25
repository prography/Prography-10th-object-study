[오브젝트 챕터 02 정리글](https://yatta.tistory.com/entry/%EC%98%A4%EB%B8%8C%EC%A0%9D%ED%8A%B8-%EC%B1%95%ED%84%B0-02-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)



### 회고
헉... 너무 재밌다. 특히 '05 추상화와 유연성'부분에서 할인 정책이 없는 경우 조건문을 구현하는 방식을 먼저 알려주고 그 뒤 추상화를 이용하는 방법을 알려주는 부분에서 많이 배웠다.
```java
public class Movie {
    public Money calculateMovieFee(Screening screening) {
        // 조건문으로 응답해주는 방식에서
        if(discountPolicy != null) {
            return fee;
        }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

// 다형성을 사용한 방식으로 변경
public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
```

1) 메시지와 메서드는 다르다

2) 결합되지 않아야 유연한 설계가 가능하다.

3) 구현과 관련된 모든 것들은 트레이드 오프의 대상이 된다.

세 가지 메세지를 중요하게 강조한 것 같다. 나는 3번이 특히 많이 다가왔다. 앞으로 계속해 개발을 하면서 트레이드 오프를 잘 할 수 있는 개발자가 되고 싶다.


오브젝트는 코드를 따라가며 함께 고치는 방식이 무척 도움이 되고 좋은 것 같다. 개념과 코드가 적절하게 섞여서 이해하기도 편하다. 