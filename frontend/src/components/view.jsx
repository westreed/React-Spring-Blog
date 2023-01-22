const Viewer = ({content}) => (
    <div
        className="ck-content"
        dangerouslySetInnerHTML={{ __html: content }}
    ></div>
);

export default Viewer;