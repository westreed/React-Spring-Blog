import { Link } from "react-router-dom";


const Categories = (props) => {
    console.log(props);
    return (
        <div>
            <h1>Categories</h1>
            <Link to='/'>To Home</Link>
        </div>
    );
}

export default Categories;