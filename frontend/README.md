# 참고자료

1. Route 설정으로 데이터 넘기기

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
2. Bootstrap 참고 https://react-bootstrap.netlify.app/components/alerts