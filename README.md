# React.js + Spring 공부

공부하려고 만든 레포.<br>
이것저것 대충 끄적이는 용도입니다.

## 가장 기본적인 연결

http-proxy-middleware을 통해, 특정 route가 사용할 target 주소를 Backend로 변경함.

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

그 이후에는 axios를 통해, 특정 route로 데이터를 요청하면 됨.

```js
const [data, setData] = useState('');

useEffect(() => {
    axios.get('/api/test')
    .then(response => setData(response.data))
    .catch(error => console.log(error))
}, []);
```
