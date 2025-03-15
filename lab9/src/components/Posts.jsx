
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { usePostContext } from "../PostContext";
import API_BASE_URL from "../config";

const Posts = () => {
    const { setSelectedPostId } = usePostContext();
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch(`${API_BASE_URL}/posts`)
            .then((res) => res.json())
            .then((data) => {
                setPosts(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading posts...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div>
            <Link to="/new" className="bg-green-500 text-white px-4 py-2 rounded">Add New Post</Link>
            <ul className="mt-4 space-y-3">
                {posts.map((post) => (
                    <li key={post.id} className="p-3 border rounded shadow">
                        <h3 className="text-lg font-semibold">
                            <Link
                                to={`/posts/${post.id}`}
                                className="text-blue-500 hover:underline"
                                onClick={() => setSelectedPostId(post.id)}
                            >
                                {post.title}
                            </Link>
                        </h3>
                        <p>{post.content.substring(0, 100)}...</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Posts;
