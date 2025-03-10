
export default function Post({ details, setPostDetails }) {

    return (
        <>
            <div className="col-4">
                <div className="box" onClick={() => setPostDetails(details)}>
                    <p className="">
                        ID: {details.id}
                    </p>

                    <p className="">
                        Title: {details.title}
                    </p>

                    <p className="">
                        Author: {details.author}
                    </p>

                </div>
            </div>
        </>
    );
}