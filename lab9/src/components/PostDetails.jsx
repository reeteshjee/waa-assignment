
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { usePostContext } from "../PostContext";
import API_BASE_URL from "../config";

const PostDetails = () => {
    const { selectedPostId } = usePostContext();
    const navigate = useNavigate();
    const [post, setPost] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (!selectedPostId) {
            setError("No post selected.");
            return;
        }

        fetch(`${API_BASE_URL}/posts/${selectedPostId}`)
            .then((res) => res.json())
            .then(setPost)
            .catch((err) => setError(err.message));
    }, [selectedPostId]);

    const handleDelete = () => {
        fetch(`${API_BASE_URL}/posts/${selectedPostId}`, { method: "DELETE" })
            .then(() => navigate("/"))
            .catch((err) => setError(err.message));
    };

    if (error) return <p>{error}</p>;
    if (!post) return <p>Loading...</p>;

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold">{post.title}</h2>
            <p>{post.content}</p>
            <button onClick={handleDelete} className="mt-4 bg-red-500 text-white px-4 py-2 rounded">Delete</button>
        </div>
    );
};

export default PostDetails;
