import { useSelector } from "react-redux"
import { Route } from "react-router-dom"


const PrivateRoute = ({role, component: Component, ...rest}) => {
    const member = useSelector((state) => state.member.data)
    return (
        <Route
            {...rest}
            render={props => {
                if(role === member.role){
                    return <Component {...props} />
                }
                else{
                    return <div>비정상 접근</div>
                }
            }}
        />
    )
}

export default PrivateRoute;