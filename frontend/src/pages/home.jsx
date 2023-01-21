import { Link } from "react-router-dom";

const Home = (props) => {
    console.log(props);
    return (
        <div>
            <h1>Home</h1>
            <Link to='/categories'>To Categories</Link>
        </div>
    );
}

export default Home;