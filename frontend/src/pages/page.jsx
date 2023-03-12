import PageList from "../components/pageList";


const Page = (props) => {
    return (
        <div style={{width:"100%"}}>
            <PageList headerRef={props.headerRef}/>
        </div>
    );
}

export default Page;