
export default function Details({ details }) {
    return (
        <div className="row mt-5">
            <div className="card">
                <div className="card-body">
                    <h3 className="text-center">{details.title}</h3>
                    <p className="text-center">{details.author}</p>
                    <p>This is the content in the post</p>
                    <div className="d-flex align-items-center justify-content-center">
                        <button className="btn btn-sm btn-primary me-4">
                            Edit
                        </button>
                        <button className="btn btn-sm btn-danger">
                            Delete
                        </button>
                    </div>
                </div>
            </div>
        </div>
    )
}