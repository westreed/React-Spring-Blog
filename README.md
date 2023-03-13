# React.js + Spring + MySQL 공부

공부하려고 만든 레포. 이것저것 대충 끄적이는 용도입니다. <br>
사이트링크는 http://westreedserver.kro.kr 입니다. <br>

## 사용된 기술스택

* React.js
* React-Redux
* Spring
* SpringBoot
* JPA
* MySQL

## 사용된 오픈소스

* CKEditor5 (Post Editor)

## 서버 배포

```bash
serve -s build -p 80 # React앱을 serve로 배포 (프록시 설정이 불가능해서 사용 X)
java -jar -Dspring.profiles.active=prod 파일명.jar
```

React 배포는 Nginx를 사용함.
```bash
server {
  listen 80; # 80 포트, http 기본 포트입니다.
  error_page 404 /index.html; # 페이지를 못 찾으면 /index.html 페이지를 보여줍니다.
  location / {
    root /home/blog/build; # /home/blog/build에서 파일을 찾아서 보여줍니다.
    index index.html; # 초기 페이지를 설정합니다.
    try_files $uri $uri/ /index.html;
  }
  location /api { # /api로 시작하는 요청을 처리합니다.
    proxy_pass http://localhost:8080; # API 서버 (Spring)에 요청하게 됩니다.
  }
}
```

위의 Nginx 서버 설정을 저장하고, 아래의 명령어로 시작하면 된다.

```bash
sudo systemctl stop nginx
sudo systemctl start nginx
sudo systemctl status nginx # 웹서버 동작 상태 확인하는 명령어
```

## 개선해야할 사항

> 개선사항들은 면접이 끝나면, 차근차근 적용해보기.

1. Git Commit
- ADD, UPDATE, FIX, REV 방식은 시각적으로도, 또한 코드 추적시에도 불편하다.
- 앞으로 Commit을 할 땐, 제대로 규칙을 세워서 내용을 작성하기.
```
{타입}: {커밋 제목}
```
```
Type List
* feat: A new feature
* fix: A bug fix
* docs: Changes to documentation
* style: Formatting, missing semi colons, etc; no code change
* refactor: Refactoring production code
* test: Adding tests, refactoring test; no production code change
* chore: Updating build tasks, package manager configs, etc; no production code change
```

2. Git Branch
- 이부분은 아직까지는 필요성을 느끼진 못하고 있음.
- 보통 main, dev, feat 순으로 브랜치를 나눠서 작업을 진행하는 걸 봤었음.
- feat 브랜치를 만들 때, front, back도 구분해서 만들기.

3. Notion
- 자료 정리는 md 파일보다는 노션을 조금 더 적극적으로 활용하기.

## Preview

PC 화면
<div style="display:flex; flex-direction:row;">
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/PC-1.png" width="49%" height="49%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/PC-2.png" width="49%" height="49%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/PC-3.png" width="49%" height="49%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/PC-4.png" width="49%" height="49%" />
</div>


모바일 화면
<div style="display:flex; flex-direction:row;">
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/M-1.png" width="24%" height="24%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/M-2.png" width="24%" height="24%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/M-3.png" width="24%" height="24%" />
  <img src="https://github.com/westreed/React-Spring-Blog/blob/main/img/M-4.png" width="24%" height="24%" />
</div>
