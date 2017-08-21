# Handling va


int print(const char* format, ...)

- format: '고정인수'라 불린다. 생략기호 이전에 있는 인수. 이는 반드시 서식 문자열이어야 한다.
- 컴파일러는 이러한 가변 인수들을 함수에 전달해준다. 하지만 이를 올바르게 처리하는 것은 해당 함수의 몫.
-

- reference
http://jangsalt.tistory.com/entry/%EA%B0%80%EB%B3%80-%EC%9D%B8%EC%88%98-vastart-vaend-vaarg-valist

- handling format with va
http://rockdrumy.tistory.com/383

- formatting va args to generate full complete string
https://stackoverflow.com/questions/19009094/c-variable-arguments-with-stdstring-only
http://www.cplusplus.com/reference/cstdio/vsprintf/
https://stackoverflow.com/questions/2342162/stdstring-formatting-like-sprintf/25346632#25346632
https://pastebin.com/DnfvzyKP
https://pastebin.com/7U6iCUMa
