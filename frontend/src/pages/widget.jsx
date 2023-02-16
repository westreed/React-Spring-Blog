import Category from "../components/category";
import Profile from "../components/profile";


const Widget = () => {
    return (
        <div className="widget" style={{display:"flex", flexDirection:"column"}}>
            <Profile/>
            <Category/>
        </div>
    );
}

export default Widget;