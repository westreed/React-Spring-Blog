# frontend 공부

## TODO

1. https://supersfel.tistory.com/135

## 참고자료

### 1. Route 설정으로 데이터 넘기기

```js
<div className="App">
    <HashRouter>
        <Routes>
            <Route exact path='/' element={<Home/>}></Route>
            <Route exact path='/about/:id' element={<About/>}></Route> {/* :id 부분이 data param */}
        </Routes>
    </HashRouter>
</div>

const about = (props) => {
    console.log(props);
    console.log(props.match.params.id);
}
```
---
### 2. Bootstrap 참고

* https://react-bootstrap.netlify.app/components/alerts
---

### 3. CKEditor5 적용

* https://velog.io/@yund_272/%EB%A6%AC%EC%95%A1%ED%8A%B8-CKEditor5-%EC%A0%81%EC%9A%A9%EA%B8%B0-88vylruv


---
### 4. Environment key "NODE_ENV" is unknown

```javascript
npm install -g win-node-env
```

출처 : https://stackoverflow.com/questions/11928013/node-env-is-not-recognized-as-an-internal-or-external-command-operable-comman

---
### 5. 목차 (ToC)

https://naubull2.tistory.com/166

---

### 6. Json Web Token

https://tech-monster.tistory.com/95

---