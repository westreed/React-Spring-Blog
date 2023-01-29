import { useEffect } from "react";



const Profile = () => {

    useEffect(() => {
        console.log("프로필 갱신됨");
    })

    return (
        <div className="blogCard text-center shadow-sm bg-body rounded">
            <img src='/avatar.png' style={{maxHeight:"150px", objectFit: "cover"}} alt="profile" />
            <h5 className="mt-3">갈대</h5>
            <div style={{fontSize:"15px"}}>
                <p className="mb-0">이것저것 개발하는게</p>
                <p>재밌는 개발자이야기</p>
            </div>
        </div>
    );
}

export default Profile;