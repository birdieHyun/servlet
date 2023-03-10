# 정리 - 섹션 4 정리  
1. 정리를 할 땐, 구조를 바꾸거나 세세한 것을 바꾸거나 생각하고 하기
  

2. 단순 반복되는 뷰 로직 분리  
  
3. 모델 추가 
   - 서블릿 종속성 제거 
   - 뷰 이름 중복 제거 -> 물리 이름을 넣는 것이 아닌 논리 이름을 넣는다. 
  
4. 단순하고 실용적인 컨트롤러 
   - v3 와 비슷 
   - 구현할 때 ModelView 를 직접 생성해서 반환하지 않도록 편리한 인터페이스 제공 
  
5. v3 유연한 컨트롤러
   - 어댑터 도입 
   - 어댑터를 추가해서 프레임워크를 유연하고 확장성 있게 설계 
   - v1, v2 를 어댑터 사용하려면 약간의 손을 봐워야 한다. 
  
여기서 애노테이션 사용해서 컨트롤러를 더 편리하게 발전시킬 수 있다.  
바로 애노테이션을 지원하는 어댑터를 추가하면 된다.  -> 스프링이 이미 지원해준다. 
다형성과 어댑터 덕분에 기존 구조를 유지하면서 프레임워크의 기능을 확장할 수 있다.  
  
### 스프링 MVC  
여기서 더 발전시키면 좋겠지만, 스프링 MVC 의 핵심 구조를 파악하는데 필요한 부분은 모두 만들어보았다.  
스프링 MVC에서도 어댑터가 매우 중요하다!  
  
인터페이스랑 구현을 분리하는 것이 스프링에서 정말 잘 만들어져있다. OCP 지키면서 설게할 수 있게 만들어져 있다.   
  
스프링에는 ViewResolver 도 인터페이스로 구현되어 있다.   

  
**프레임워크나 공통 기능이 수고로워야 사용하는 개발자가 편리해진다.**  
  
처음 다형성을 접하면 힘들지만, 계속해서 적용하려 하면 실력이 늘 것이다.   
if else 로 개발하는 습관보다 이렇게 다형성을 활용하는 것이 더 좋다.  
  
단순하면 if else 쓰는게 좋을 수 있지만,  
추후 확장성을 위해 다형성을 활용하는 것이 좋다.  
  