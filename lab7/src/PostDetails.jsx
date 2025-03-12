
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import API_BASE_URL from "./config";


const PostDetails = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [post, setPost] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch(`${API_BASE_URL}/posts/${id}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Post not found");
                }
                return response.json();
            })
            .then((data) => {
                setPost(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }, [id]);

    const handleDelete = () => {
        fetch(`${API_BASE_URL}/posts/${id}`, {
            method: "DELETE",
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to delete post");
                }
                return response.json();
            })
            .then(() => {
                navigate("/"); // Redirect to the dashboard after deletion
            })
            .catch((err) => {
                setError(err.message);
            });
    };

    if (loading) return <p>Loading post details...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold">{post.title}</h2>
            <p className="mt-2">{post.content}</p>
            <button
                onClick={handleDelete}
                className="mt-4 bg-red-500 text-white px-4 py-2 rounded hover:bg-red-700"
            >
                Delete Post
            </button>
        </div>
    );
};

export default PostDetails;
