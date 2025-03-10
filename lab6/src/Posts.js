
import Post from "./Post";

export default function Posts({ posts, setPostDetails }) {
    return (
        <>
            <div className="row">
                {
                    posts.map(post => (
                        <Post setPostDetails={setPostDetails} key={post.id} details={post} />
                    ))
                }
            </div>
        </>
    )
}