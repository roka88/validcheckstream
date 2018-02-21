# ValidCheckStream
안드로이드(android) 로그인 폼이나, 회원가입 폼에 사용할 유효성 검사관련 Checking Stearm

Java8로 넘어오면서 interface 코드를 줄일 수 있었음.
상당히 간단한 구조로 되어있어서 멀티 쓰레딩을 생각할 경우 코드를 변경해서 사용할 수 있음

더이상 지저분한 코드가 
if (userid.match(regex)) {

} 
if (userPw.match(regex)) {

}
if (..) {

}
싫어서 만듬.

#Gradle
<pre>
repositories {
    ...
    maven { url "https://jitpack.io" }
}
</pre>

<pre>
dependencies {
    compile 'com.github.roka88:validcheckstream:0.0.2'
}
</pre>


#example
<h5>Regex Example</h5>
<pre>
public static final String PASSWORD_EXPREG = "^(\\w{4,8})$";
public static final String EMAIL_EXPREG = "^[-_\\w]+@\\w+\\.\\w+.?\\w+$";

private boolean isIdRegexCorrect(String userId) {
    return userId.matches(EMAIL_EXPREG);
}

private boolean isPwRegexCorrect(String userPw) {
    return userPw.matches(PASSWORD_EXPREG);
}

private boolean isPwConfirmCorrect(String userPw, String userPwConfirm) {
    return userPw.equals(userPwConfirm);
}
</pre>

<h5>ValidCheckStream Example</h5>
<pre>
String msg = ValidCheckStream.stream()
                .check(() ->isIdRegexCorrect(userId), "유효한 이메일이 아닙니다.")
                .check(() ->isPwRegexCorrect(userPw), "패스워드 형식이 잘못되었습니다.")
                .check(() ->isPwConfirmCorrect(userPw, userPwConfirm), "입력하신 패스워드와 맞지 않습니다.")
                .result();
if (!msg.equals("ok") {
    // 유효성 검사 실패시
    // print("msg")
} else {
    // 유효서 검사 성공시
    // active
}
</pre>

<h5>Result</h5>
<pre>
<ol>
<li>모든 유효성 검사가 통과시, Return String Value는 "ok"를 return</li>
<li>유효성 검사도중 검사 실패시, Return String Value는 ValidCheckFuntion의 두번째 파라미터에 지정한 String을 반환. 
<li>유효성 검사는 check() Method 순서대로 진행
</ol>
</pre>

#Interface
<pre>
public interface ValidCheckFunction {
    public boolean function();
}
</pre>

#License
<pre>
Copyright 2016 Roka

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>

