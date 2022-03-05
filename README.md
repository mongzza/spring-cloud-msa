# spring-cloud-msa
 
- 강의 링크 : https://inf.run/g5JW

## Section2
API Gateway Service with filter and load balancing

### Branches
- section2/spring-cloud-gateway
- section2/custom-filter
- section2/filter-with-javacode
- section2/filter-with-yml
- section2/custom-filter
- section2/global-filter
- section2/custom-filter-for-second
- section2/gateway-loadbalancer

다음 섹션부터는 1섹션 1브랜치하고, 강의 소제목을 커밋메시지로 사용

### Keywords
- Round-robin
  - 프로세스에 일정시간을 할당하고, 할당된 시간이 지나면 그 프로세스는 잠시 보류한 뒤 다른 프로세스에게 기회를 주고, 또 그 다음 프로세스에게 하는 식으로, 돌아가며 기회를 부여하는 운영방식
  - 프로세스들 사이에 우선순위를 두지 않고, 순서대로 시간단위(Time Quantum)로 CPU를 할당하는 방식
    
## Section4
User service of E-commerce

### Branch
- section4/user-microservice

### Keywords
- MSA에서의 트랜잭션 처리 방법
- Saga 패턴
- Event Souring
- CQRS
- Service mesh

### TODO
- TC
- ModelMapper 라이브러리와 final 키워드
- ModelMapperUtils의 ModelMapper를 싱글톤으로 사용 -> Bean 등록?
