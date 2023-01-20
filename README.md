# React.js + Spring 공부

공부하려고 만든 레포.<br>
이것저것 대충 끄적이는 용도입니다.

## 가장 기본적인 연결

참고로 출처는 [Spring Boot + React.js 개발환경 연동하기](https://velog.io/@u-nij/Spring-Boot-React.js-%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD-%EC%84%B8%ED%8C%85)를 참고함.<br>
1. 우선 http-proxy-middleware을 통해, 특정 route가 사용할 target 주소를 Backend로 변경함.

```js
// setupProxy.js 파일

const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'http://localhost:8080',	// 서버 URL or localhost:설정한포트번호
      changeOrigin: true,
    })
  );
};
```

2. 그 이후에는 axios를 통해, 특정 route로 데이터를 요청하면 됨.

```js
const [data, setData] = useState('');

useEffect(() => {
    axios.get('/api/test')
    .then(response => setData(response.data))
    .catch(error => console.log(error))
}, []);
```
