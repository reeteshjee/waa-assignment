
import { useEffect, useState } from "react";
import API_BASE_URL from "./config";


const Posts = () => {
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const fetchPosts = () => {
        fetch(`${API_BASE_URL}/posts`)
            .then((response) => {
                return response.json();
            })
            .then((data) => {
                setPosts(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    };
    useEffect(() => {
        fetchPosts();
    }, []);

    if (loading) return <p>Loading posts...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold mb-4">Posts</h2>
            <ul className="space-y-3">
                {posts.map((post) => (
                    <li key={post.id} className="p-3 border rounded-lg shadow">
                        <h3 className="text-lg font-semibold">{post.title}</h3>
                        <p>{post.content}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Posts;
