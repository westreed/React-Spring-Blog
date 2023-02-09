import { useSelector } from "react-redux";
import { Link } from "react-router-dom";

const Profile = () => {
    console.log('Profile');
    const member = useSelector((state) => state.member.data);

    return (
        <div className="blogCard text-center shadow-sm bg-body rounded">
            <img src='/avatar.png' style={{maxHeight:"150px", objectFit: "cover"}} alt="profile" />
            <h5 className="mt-3">갈대</h5>
            <div style={{fontSize:"15px"}}>
                <p className="mb-0">이것저것 개발하는게</p>
                <p>재밌는 개발자이야기</p>
            </div>
            {member != null ?
                <div>
                    {member.role === 'admin' ? <Link to='/settings'>관리</Link> : null}
                </div>
            : null}
        </div>
    );
}

export default Profile;